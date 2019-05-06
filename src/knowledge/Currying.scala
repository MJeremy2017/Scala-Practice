package knowledge

object Currying {

  def main(args: Array[String]): Unit = {

    def add(a: Int)(b: Int) = a + b

    val onePlusFive = add(1)(5) // 6

    val addFour = add(4)_ // (Int => Int)

    val twoPlusFour = addFour(2) // 6

    assert(onePlusFive == twoPlusFour) // true

    // create an operator
    def curryBinaryOperator[A](operator: (A, A) => A): A => (A => A) = {

      def curry(a: A): A => A = {
        (b: A) => operator(a,b)
      }

      curry
    }

    def add2(a: Int, b: Int) = a + b // (Int, Int) => Int
    def multiply(a: Int, b: Int) = a * b // (Int, Int) => Int

    val addCurried = curryBinaryOperator(add2) // Int => (Int => Int)
    val multiplyCurried = curryBinaryOperator(multiply) // Int => (Int => Int)

    println("add operator", addCurried(2)(3))
    println("multiply operator", multiplyCurried(2)(3))

  }
}
