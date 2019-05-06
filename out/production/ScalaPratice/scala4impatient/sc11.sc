import scala.math._

val num = 3.3
val fun = ceil _  // double => double

fun(num)

Array(3, 2, 1.1).map(fun)

val fun2 = (x: Double) => 3*x
Array(3, 2, 1.1).map(fun2)

def valueat(f: (Double) => Double) = f(0.25)  // a function as parameter

valueat(ceil _)

def mulBy(factor: Double) = (x: Double) => factor*x

val f = mulBy(3)
f(10)  // 30

val fun3: (Double) => Double = 3*_
fun3(10)

(1 to 9).map("*" * _).foreach(println _)

(1 to 9).filter(_ % 2 == 0)

(1 to 9).reduceLeft(_ * _)

("mary had a little lamd").split(" ").sortWith(_.length < _.length)

val mul = (x: Int, y: Int) => x*y
val mulatatime = (x: Int) => (y: Int) => x*y

mul(3, 2)
mulatatime(3)(2)

//def until(condition: => Boolean)(block: => Unit): Unit = {
//  if (!condition)
//    block
//    until(condition)(block)
//}
//
//var x = 5
//until(x == 0) {
//  x -= 1
//  println(x)
//}

def sqrt(f: Int => Int, low: Int, high: Int) = {
  println( (low to high).map(f) )
}

sqrt(x=>x*x, -3, 3)

Array(3, 2, 11, 4).reduceLeft( (a, b) => if (a > b) a else b)

def fac(x: Int) = (1 to x).reduceLeft(_*_)

Array(3, 4, 2).foldLeft(1)(_ + _)

def largest(f: Int => Int, Input: Seq[Int]) = {
  Input.map(f).reduceLeft((a, b) => if (a > b) a else b)
}

largest(x => x*x, List(-2, 3, 4))

List(1, 2, 3).indexOf(2)

val pair = (1 to 3).zip(2 to 4)

def adjustPair(op: (Int, Int) => Int )(a: Int, b: Int): Int = op(a, b)

