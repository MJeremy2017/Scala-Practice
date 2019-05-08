package http

/**
  * WebServer with marshalling
  */

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import akka.Done
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.StatusCodes

import scala.concurrent.Future
import scala.io.StdIn
// for JSON serialization/deserialization following dependency is required:
// "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.7"
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import spray.json.DefaultJsonProtocol._


object WebServer2 {

  // needed to run the route
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  // needed for the future map/flatmap in the end and future in fetchItem and saveOrder
  implicit val executionContext = system.dispatcher

  var orders: List[Item] = Nil

  implicit val itemFormat = jsonFormat2(Item)
  implicit val orderFormat = jsonFormat1(Order)

  // domain model
  final case class Item(name: String, id: Long)
  final case class Order(items: List[Item])

  def fetchItem(itemId: Long): Future[Option[Item]] = Future {
    orders.find(_.id == itemId)
  }

  def saveOrder(order: Order): Future[Done] = {
    orders = order match {
      case Order(items) => items ::: orders
      case _            => orders
    }

    Future {Done}
  }

  def main(args: Array[String]): Unit = {

    val route = get {
      pathPrefix("item" / LongNumber) {
        id =>
          val maybeItem = fetchItem(id)

          onSuccess(maybeItem) {
            case Some(item) => complete(item)  // marshallable
            case None       => complete(StatusCodes.NotFound)
          }
      }
    } ~
    post {
      path("create-order") {
        entity(as[Order]) {
          order =>
            val saved = saveOrder(order)
            onComplete(saved) {
              done => complete("order created \n")
            }
        }
      }
    }

    val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)
    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done


  }

}
