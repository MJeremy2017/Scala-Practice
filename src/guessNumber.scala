import scala.io.StdIn.{readLine}
import scala.math._

object guessNumber {
  def main(args: Array[String]): Unit = {
    var number = 0
    do {
      println("Guessed number:")
      number = readLine.toInt
    } while (number != 10)

    printf("you are right %d", 10)
  }

}
