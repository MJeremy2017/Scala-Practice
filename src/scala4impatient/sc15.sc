import java.time.LocalTime

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

Future {
  Thread.sleep(10000)
  println(s"future time ${LocalTime.now}")
}
println(s"current time ${LocalTime.now}")

Future { for (i <- 1 to 10) { print("A"); Thread.sleep(10) } }
Future { for (i <- 1 to 10) { print("B"); Thread.sleep(10) } }

val f = Future {
  Thread.sleep(2)
  42
}

// Await.ready(f, 1.seconds)
println(f.value)

f.onComplete({
  case Success(v) => println(v)
  case Failure(ex) => println(ex.getMessage)
} )

val n1 = Future { Thread.sleep(1000) ;
  2 }
val n2 = Future { Thread.sleep(1000);
  40 }

println(n1)
