def signum(x: Double) = {
  if (x > 0) 1
  else if (x == 0)  0
  else  -1
}

val x = signum(3)
signum(-2)

def loop(y: Int): Unit = {
  var x = y
  while (x >= 0) {
    println(x)
    x -= 1
  }
}

loop(4)

def power(x: Int, n: Int): Double = {
  if (n > 0) {
    if (n % 2 == 0) power(x, n / 2) * power(x, n / 2)
    else x * power(x, n - 1)
  } else if (n == 0)
    1
  else
    1.0/power(x, -n)
}

power(2, 5)
power(2, -5)

// arrays

val nums = new Array[Int](10)  // initialized with 0
val s = Array("Hello", "World")

s(0) = "good"
s

import collection.mutable.ArrayBuffer

val b = ArrayBuffer[Int]()
b += 1
b += (1, 2, 3)
b ++= Array(4, 5)

b.trimEnd(3)  // removes the last 3 elems

b.insert(2, 11)
b.insert(2, 8, 9)

b.remove(2)
b.remove(2, 2)  // second param how many elems to remove

b.toArray

for (i <- b) println(i)

for (i <- 0 until b.length by -1) println(b(i))

b.indices

val a = for (elem <- b) yield 2*elem

b.remove(0)
b.remove(0)
b

// common algorithms
val c = Array(1, 7, 2, 9)
c.sum
c.max
c.sorted

c.sortWith(_ > _)
c.mkString(" and ")
c.mkString("{", ",", "}")

c.toString()

// multidimensional arrays
val matrix = Array.ofDim[Double](3, 4)

val tri = new Array[Array[Int]](10)
for (i <- tri.indices)
  tri(i) = new Array[Int](i+1)


import scala.util.Random

val arr = for (_ <- 1 until 5) yield Random.nextInt(5)

def swap(arr: Array[Int])={
  val res = new Array[Int](arr.length)
  for (i <- arr.indices)
    if (i % 2 == 0)
      res(i) = arr(i+1)
    else
      res(i) = arr(i-1)
  res
}

swap(Array(1, 2, 3, 4))

val arr2 = Array(1.2, 3.0, 1.1)
arr2.sum/arr2.length

arr2.sortWith(_ > _)

arr2.toBuffer.sortWith(_ > _)










