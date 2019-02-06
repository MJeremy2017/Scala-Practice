import java.lang.Comparable

class Pair[T, S](first: T, second: S)

val p = new Pair(3, "string")

def getMiddle[T](arr: Array[T]) = arr(arr.length/2)

val f = getMiddle[String] _  // store the function

class Pair2[T <: Comparable[T]](first: T, second: T) {
  def getsmaller = if (first.compareTo(second) < 0) first else second

  def newPair[R >: T](newFirst: R) = new Pair2[R](newFirst, second)  // R is supertype of T
}

val p2 = new Pair2[String]("fred", "broker")

p2.getsmaller

