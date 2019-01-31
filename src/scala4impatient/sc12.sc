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
