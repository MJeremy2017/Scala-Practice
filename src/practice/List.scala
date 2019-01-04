package practice

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

// type parameter applied to a class informs that a class can have instances of different types
class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false
}

class Nil[T] extends List[T] {
  override def isEmpty: Boolean = true
  override def head: Nothing = throw new NoSuchElementException("head invalid")
  override def tail: Nothing = throw new NoSuchElementException("tail invalid")
}

object List {
  def apply[T](x1: T, x2: T) = new Cons(x1, new Cons(x2, new Nil))
  def apply[T]() = new Nil
}
