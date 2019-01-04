package practice

object overrides {

  def main(args: Array[String]): Unit = {

  }
}

abstract class Base {
  def foo = 1
  def bar: Int
}

class Sub extends Base {
  override def foo: Int = 2
  def bar = 3
}
