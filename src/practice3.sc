val a = (10, 2, 3)
a._1
a._2
a._3

5/2.0

var a1 = new Array[Int](3)
a1(0) = 1; a1(1) = 3; a1(2) = 2

import java.util

import Array._
import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer
concat(a1, a1)

var b : List[String] = List("A", "B")
val nums = List(1, 3, 2)

val mm = Map("a" -> "1", "c" -> 3)
mm.apply("a")

val t = ("3", "aaa")
t.swap

Some(3).isEmpty

val it = Iterator("3", 3)
while (it.hasNext) {println(it.next())}


List(3, 1, "s")

// val x = 3
(x:Int) => x*2

def f(x:Int) :Int = x*2

def prod(f: Int => Int)(g: Int => Int)(a: Int, b: Int): Int = f(g(a+b))

prod(x => 2*x)(x => x)(3, 8)


class Rational(x:Int, y:Int) {
  private def gcd(a:Int, b:Int): Int = if (b==0) a else gcd(b, a%b)
  private val g = gcd(x, y)
  def numer = x/g
  def denom = y/g

  def add(that: Rational) ={
    new Rational(this.numer * that.denom+ that.numer*denom, denom*that.denom)
  }

  def less(that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (less(that)) that else this

  override def toString: String = {
    numer + "/" + denom
  }

  def neg = new Rational(-numer, denom)

  def sub(that: Rational) = add(that.neg)
}

val x = new  Rational(1, 2)

val y = new  Rational(3, 4)

x.add(y)
x.neg
x.sub(y)
x.less(y)
x.max(y)

val xx = List(List(1), List(2, 3))
xx(1)
xx.flatMap(x => x)

val xy = List[Int](1, 2, 3)

var ab = List()
for (i <- xy) {
  ab = ab
}

for (x <- 0 to 4) {
  println(x)
}

val ax = Array(1, 2, 3)
ax(1)

xy ::: List(11)
11 :: xy

val q = List(2, 3, 1, 4, 2, 1)
q.tail.init

List(List("a", "b"), List(1)).flatten

type xy

xy.asInstanceOf[Any].getClass.getSimpleName

// List.fill(3, 2)("a")

q.grouped(2).flatMap(_.take(1)).foreach(println)

q.take(3)

val l = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
l.zipWithIndex.filter(x => (x._2+1)%3 != 0).flatMap(x => List(x._1))

l.splitAt(3)
l.slice(3, 7)

q.drop(2)

require(3>0)
6 % 2

(1 to 10).exists(x => x%2 == 0)

(1 to 10).foreach(x => if(x%2 == 0) println("%d is even".format(x)))

List(1, 2, 3, 2, 2).slice(1, 3)

List(3) :: List(1, 2)

List("0", "1").map(x => x++"0")

List("0", "1").map(x => {
  List("0",  "1").flatMap(_ ++ x) })

def add(x: Int)(implicit y: Int ) =  x + y

implicit val aaa = 4
add(3)

val z = (x: Int, y: Int) => x+y

def recur[T](l: List[T]): List[T] = l match {
  case h :: tail => recur(tail) ::: List(h)
  case _ => Nil
}

recur(List(1, 2 ,3))

List(1, 2, 3) ++ List(3)

val qq = List(1, 2, "as")

qq.map(_ match {
  case (_: Int) => true
  case (_: String) => false
})
