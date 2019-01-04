object MapT {
  def main(args: Array[String]): Unit = {
    val emp = Map("AA" -> "a", "BB" -> 1)
    printf("AA is %s", emp("AA"))

    val cus = collection.mutable.Map(100 -> "a", 101 -> "b")

    for ((k, v) <- cus) {
      printf("%d : %s\n", k, v)
    }

    var tupleM = (10, "daf", 1, 23)
    printf("first and second %d & %s", tupleM._1, tupleM._2)
    // println(tupleM(3))
    tupleM.productIterator.foreach(println)
    println(tupleM)

  }

}
