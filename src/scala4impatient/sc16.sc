
class Pair[T, S](first: T, second: S)

val p = new Pair(3, "string")

def getMiddle[T](arr: Array[T]) = arr(arr.length/2)

val f = getMiddle[String] _  // store the function

//class Pair2[T <: Comparable[T]](first: T, second: T) {
//  def getsmaller = if (first.compareTo(second) < 0) first else second
//
//  def newPair[R >: T](newFirst: R) = new Pair2[R](newFirst, second)  // R is supertype of T
//}

//val p2 = new Pair2[String]("fred", "broker")
//
//p2.getsmaller

class Pair3[T : Ordering](first: T, second: T) {
  def smaller(implicit ord: Ordering[T])={
    if (ord.compare(first, second) < 0) first else second
  }

  def smaller2(implicit ev: T <:< Ordered[T]) = {
    if (first < second) first else second
  }  // requires T to be subtype of ordered only when using this function
}

import scala.reflect._

class MakePair[T : ClassTag](first: T, second: T) {
  val r = new Array[T](2)
  r(0) = first
  r(1) = second
}  // context bound

new MakePair[Int](4, 3)

def firstLast[A, C](it: C)(implicit ev: C <:< Iterable[A]) = (it.head, it.last)

firstLast(List(1, 2, 3))

class Pair4[T, R](val first: T, val second: R) {
  def swap = (second, first)

  def swap2[T, R](f: T, s: R) = (s, f)
}

val pp = new Pair4(3, "st")
pp.swap
pp.first
pp.swap2("ss", 3)

Iterable