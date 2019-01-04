object increment {
  def main(args: Array[String]): Unit = {
    var i = 0
    val randletters = "sdfsdfdewq"

    for (i <- 0 until(randletters.length)) {
      println(randletters(i))
    }
  }

}

//object increment {
//  def main(args: Array[String]): Unit = {
//    var i = 0
//    while (i <= 10){
//      println(i)
//      i += 1
//    }
//  }
//
//}

// not running

object inc {
  def main(args: Array[String]): Unit = {
    println("inside")
  }
}
