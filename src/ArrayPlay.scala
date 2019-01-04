import scala.collection.mutable.ArrayBuffer


object ArrayPlay {
  def main(args: Array[String]): Unit = {
    val favNums = new Array[Int](20)
    val friends = Array("sue", "berry")

    friends(0) = "alice"

    println("Friend", friends(0))

    println("/////ArrayBuffer////")

    val friends2 = new ArrayBuffer[String]()

    friends2 += "Alice"
    friends2.insert(0, "Lily")

    for (f <- friends2)
      println(f)

    println("///////Number Array//////")
    for (i <- 0 to (favNums.length-1)) {
      favNums(i) = i
      println(favNums(i))
    }
    println("Printing foreach")
    favNums.foreach(println)

    val numDiv4 = for (num <- favNums if num % 4 == 0) yield num
    numDiv4.foreach(println)

    println("Table Operations")
    val table = Array.ofDim[Int](10, 10)

    for (i <- 0 to 9) {
      for (j <- 0 to 9) {
        table(i)(j) = i*j
      }
    }

  favNums.sortWith(_>_).foreach(println)
  }

}
