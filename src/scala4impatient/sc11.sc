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