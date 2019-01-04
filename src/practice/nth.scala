package practice

object nth {
  def nth[T](n: Int, xs: List[T]): T = {
    if (n==0) xs.head
    else nth(n - 1, xs.tail)
  }

  def main(args: Array[String]): Unit = {
    val l = new Cons(1, new Cons(2, new Nil))
    nth(1, l)
    nth(-1, l)
  }
}
