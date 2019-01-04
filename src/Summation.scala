
object Summation {
  def main(args: Array[String]): Unit = {
    def sum(num1: Int = 1, num2: Int = 1): Int = {
      return num1 + num2
    }

    println("sum is " + sum(4, 3))

    def getsum(args: Int*): Int = {
      var sum = 0
      for (i <- args) {
        sum += i
      }

      return sum
    }

    println("The summation is ", getsum(1, 2, 3))

    def factorial(num: Int): Int = {
      if (num == 1){
        return 1
      } else {
        return num * factorial(num - 1)
      }
    }

    println("Factorail is ", factorial(7))
  }

    def sayhi(): Unit = {
      println("Hellooooooo")
    }
    sayhi()

}
