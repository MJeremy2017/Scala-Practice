package knowledge

import java.io._

object TryCase {

  def main(args: Array[String]): Unit = {
    val s = "Foo"
    try {
      val i = s.toInt
    } catch {
      case e: Exception => e.printStackTrace
    }

    try {
      io.Source.fromFile("file")
    } catch {
      case e: FileNotFoundException => println("Couldn't find that file.")
      case e: IOException => println("Had an IOException trying to read that file")
    }

  }

}
