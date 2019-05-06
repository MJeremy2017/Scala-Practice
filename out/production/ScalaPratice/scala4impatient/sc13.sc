import java.util.Currency

import com.sun.source.tree.BinaryTree

// pattern matching
val ch = "+"

ch match {
  //case _ if 3 > 2 => -10
  case "+" => 1
  case "-" => -1
  case _ => 0
}

ch match {
  case "-" => 1
  case new_var => 3
}

val mm :Any = 3
mm match {
  case x: Int => println("is int")
  case y: String  => println("is String")
}

val lst = List(0, 3, 2)
//lst match {
//  case 0 :: Nil => "0"
//  case x::y::Nil => println(s"$x and $y")
//  case 0::tail => "0 ..."  // this one
//  case _ => "something else"
//}

val pair = (0, 2)

pair match {
  case (x, 0) => "second is 0"
  case (0, _) => "first is 0"
  case _ => "neither"
}

val x, y = BigInt(10) /% 3  // x = 3, y = 1

case class Currency(amount: Double, unit: String)

val amt = Currency(12.3, "USD")
amt.copy(amount = 14.2)


abstract class Item
case class Article(desc: String, price: Double) extends Item
case class Bundle(desc: String, discount: Double, items: Item*)

//def price(it: Item): Double = it match {
//  case Article(_, p) => p
//  case Bundle(_, discount, items @  _*) => items.map(price _).sum - discount
//}

abstract class MyList
case object MyNil extends MyList
case class ::(head: Any, tail: MyList) extends MyList

val scores = Map("alice" -> 3)
val aliceScore = scores.get("alice")

aliceScore match {
  case Some(score) => println(score)
  case None => println("no value")
}


for (s <- aliceScore) println(s)

Option(3)
println(Some(3))

"-3+4".map(ch => ch match {
  case '-' => -1
  case '+' => 1
  case _ => 0
})

def swap(pair: (Int, Int)) = pair match {
  case (a, b) => (b, a)
  case _ => "error"
}

swap(3, 2)

def swapHead(arr: Array[Int]) = arr match {
  case Array(a, b, rest @ _*) if arr.length >= 2 => Array(b, a, rest)
  case _ => "error"
}

swapHead(Array(3, 2, 2, 1))
swapHead(Array(1))  // error

//def sumList(lst: List[Any]): Int = lst match {
//  case h :: tail if h.isInstanceOf[Int] => h + sumList(tail)
//  case h2: List[Any] => sumList(h2) + sumList(lst.tail)
//  case Nil => 0
//}
//
//sumList(List(3, 2, 1))
//sumList(List(3, List(2, 1)))
3.isInstanceOf[Int]

sealed abstract class BinaryT
case class Leaf(value: Int) extends BinaryT
case class Node(left: BinaryT, right: BinaryT) extends BinaryT

val bt = Node(Node(Leaf(3), Leaf(2)), Node(Leaf(4), Leaf(1)))

def sumNode(tree: BinaryT): Int = tree match {
  case Node(left, right) => sumNode(left) + sumNode(right)
  case Leaf(a) => a
}

sumNode(bt)
