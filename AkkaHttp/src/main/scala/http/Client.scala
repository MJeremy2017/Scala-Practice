package http

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.stream.ActorMaterializer

import scala.concurrent.Future
import scala.util.{Failure, Success}


object Client {

  def main(args: Array[String]): Unit = {

    implicit val system = ActorSystem()
    implicit val materializer = ActorMaterializer()
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext = system.dispatcher

    val response: Future[HttpResponse] = Http().singleRequest(HttpRequest(uri="http://www.google.com"))

    response.onComplete {
      case Success(res) => println(res)
      case Failure(_)   => sys.error("something wrong")
    }

  }

}
