trait Equal {
  def isEqual(x: Any): Boolean
  def isNotEqual(x: Any): Boolean = {!isEqual(x)}
}

class Point(xc: Int, yc: Int) extends Equal {
  var x: Int = xc
  var y: Int = yc

  def isEqual(obj: Any) = obj.isInstanceOf[Point] && obj.asInstanceOf[Point].x == y
}

object Demo {
  def main(args: Array[String]) {
    val p1 = new Point(2, 3)
    val p2 = new Point(2, 4)
    val p3 = new Point(3, 3)

    println(p1.isNotEqual(p2))
    println(p1.isNotEqual(p3))
    println(p1.isNotEqual(2))
  }
}

var tp = (1, 2, "a")
(tp, "b")

var ll : List[(Int, Int)] = List((3, 2))

var newll = ll :+ (3, 3)
newll

//val l2 : List[(() => ())] = List(((1, 1), (2, 2)))
//l2
//val newl2 = l2 :+ (3, 3)
//newl2
//
//val l2 : List[((Int, Int), (Int, Int))] = List(((), ()))
//val newl2 = l2 :+ ((3, 3), (4, 4))
var l3 = List[Int]()

l3 = 4 :: l3
2 :: l3

