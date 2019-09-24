package http

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.stream.ActorMaterializer

import scala.concurrent.Future
import scala.util.{Failure, Success}


object APIRequest {

  def main(args: Array[String]): Unit = {

    implicit val system = ActorSystem()
    implicit val materializer = ActorMaterializer()
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext = system.dispatcher

    val records =
      """{
        |"records":
        |[
        |{
        |"merchantID": "*",
        |"unix_time": *,
        |"cityId": *
        |}
        |]
        |}""".stripMargin

    val request = HttpRequest(
      HttpMethods.POST,
      uri = "http://localhost:8000/api/v1/predict/drm_rest_close?tag=v1",
      entity = HttpEntity(ContentTypes.`application/json`, records)
    )

    val response: Future[HttpResponse] = Http().singleRequest(request)

    response.onComplete {
      case res: Success[HttpResponse] => println(res.get.status)
      case Failure(_)   => sys.error("something wrong")
    }

    println(records)

  }

}
