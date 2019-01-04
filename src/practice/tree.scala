package practice

object tree {

}

//abstract class Tree {
//  def isEmpty: Boolean
//  def addValue(x: Int): Tree
//}
//
//class Empty extends Tree {
//  override def isEmpty: Boolean = true
//
//  override def addValue(x: Int): Tree = new Node(x, new Empty, new Empty)
//}
//
//class Node(value: Int, left: Tree, right: Tree) extends Tree {
//  override def isEmpty: Boolean = false
//
//  override def addValue(x: Int): Tree = {
//    if (x < value) {
//      return new Node(value, left.addValue(x), right)
//    } else {
//      return new Node(value, left, right.addValue(x))
//    }
//  }
//}
