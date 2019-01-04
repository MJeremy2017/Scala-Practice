"""the present string
spans three
lines."""

println("Hello\t\tWorld\n\nend" )

val (x, y) = Pair(33, "12")

var myS :String = "My String"

class Point(val x:Int, val y:Int) {
  var a = x
  var b = y

  def move(dx: Int, dy: Int): Unit = {
    a += dx
    b += dy
    println(s"Current position is $a, $b")
  }
}

val p1 = new Point(10, 10)
p1.move(3, 3)

class Location(override val x:Int, override val y:Int,
               val z:Int) extends Point(x, y) {
  var c = z

  def move(dx: Int, dy: Int, dz: Int): Unit = {
    a += dx
    b += dy
    c += dz
    println("Current location $a, $b, $c")
  }

}