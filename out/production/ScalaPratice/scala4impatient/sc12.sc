import scala.collection.mutable.ArrayBuffer

val l = List(3, 2, 2, 4)
val iter = l.iterator
while (iter.hasNext)
  println(iter.next())

Iterable(1, 2, 3)
Iterator(1, 2, 3).next()

Seq(1, 2) == List(1, 2)  // true

9 :: List(1, 2)

def sum(lst: List[Int]): Int = lst match {
  case Nil => 0
  case h :: t => h + sum(t)
}

sum(List(3, 4, 1))

Set(1, 2) + 3

val digits = Set(1, 5, 2, 3)
digits.contains(1)
Set(1, 4).subsetOf(digits)

l :+ List(1, 2)
l +: List(1, 2)

l :: List(1)
l ++ Vector(1, 2, 3)  // ok
l ++ Set(1, 2)  // ok
l ++: List(1)

Vector(1, 2) :+ 4

val ar = ArrayBuffer(1, 2)
ar += 3

l.mkString(":", ",", ":")

(1 to 10).flatMap(i => (1 to i).map(j => j * i))

val names = List("Jane", "May", "Yoo")
names.foreach(println)

"-3+4".collect {case '-' => -1; case '+' => 1}

val words = "Hello"
words.groupBy(_.toUpper)
List(3, 2, 3).foldLeft(0)(_ + _)

(0 /: List(3, 2, 1))(_ + _)  // same as foldleft

Map("a" -> 3) + ("s" -> 2)

("Mississippi").foldLeft(Map[Char, Int]()) {
  (m, c) => m + (c -> (m.getOrElse(c, 0) + 1) )
}

(1 to 10).scanLeft(0)(_ + _)

val price = List(2, 3, 1.3)
val quantity = List(10, 2, 1)

price.zip(quantity)
"Scala".zipWithIndex.map( x => (x._1, x._2) )

(1 to 10).scanLeft(0)(_+_)

def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n+1)

val st = numsFrom(3)  // Stream(3, ?)
st.take(5).force
st  // cached

var mm = scala.collection.mutable.Map[String, Int]()
mm += ("M" -> 4)
mm.getOrElse("S", 0)

val stt = "Mississippi"
stt.foldLeft(collection.mutable.Map[Char, List[Int] ]()) {
  (m, c) => m + (c -> m.getOrElse(c, List(stt.indexOf(c)) ) )
}

List(3, 2, 1, 2, 4).zipWithIndex.filter(_._2 % 2 == 0).map(_._1)

val mm2 = Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)

Array("Tom", "Harry").map(x => mm2.getOrElse(x, None))

List("Hello", "World").mkString(",")
List("Hello", "World", "!").reduceLeft((a, b) => a + "," + b)

val ls = List(1, 2, 3)
(ls :\ List[Int]())(_ :: _)
//
ls.foldLeft(List[Int]())( (a, b) => b :: a )


val ar2 = Array(1, 2, 3, 4, 5, 6)
ar2.grouped(3).toArray

for (i <- 1 to 10; j <- 1 to i) yield i*j

(1 to 10).map(i => (1 to i).map(j => i*j))
