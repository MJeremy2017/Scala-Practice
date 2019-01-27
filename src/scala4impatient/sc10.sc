
val l = 1 :: 2 :: Nil  // right-associative

class Fraction(val n: Int, val d: Int) {

}

object Fraction {
  def apply(n: Int, d: Int): Fraction = new Fraction(n, d)

  def unapply(input: Fraction) = if (input.d == 0) None else Some((input.n, input.d))
}

val f = Fraction(3, 2)
val f2 = new Fraction(3, 2)

"fred tan".indexOf(" ")  // 4

case class Currency(amount: Double, unit: String)

object Number {
  def unapply(input: String) =
    try {
      Some(input.trim.toInt)
    } catch {
      case e: NumberFormatException => None
    }
}

val Number(a) = "123"  // a = Number.unapply("123")
a + 1  // 124

object IsCompound {
  def unapply(inp: String) = {
    inp.contains(" ")
  }
}

val isCompound = "van linden"

object Name {
  def unapplySeq(input: String): Option[Seq[String]] =
    if (input.trim == "") None else Some(input.trim.split("\\s+"))
}

// val Name(s) = "van den linden"

//
3 + 4 -> 5

12 % 8

def gcd(a: Int, b: Int): Int = {
  if (b == 0) a
  else if (a > b) gcd(b, a % b)
  else gcd(a, b % a)
}

gcd(12, 8)
gcd(15, 9)
gcd(9, 15)

class Money(val dollar: Int, val cents: Int) {
  val a = 1
  def +(that: Money):Money = {
    val new_cent = (cents + that.cents)%100
    val new_dollar = dollar + that.dollar + (cents + that.cents)/100

    Money(new_dollar, new_cent)
  }

  def ==(that: Money): Boolean = {
    if ((this.dollar == that.dollar) & (this.cents == that.cents)) true else false
  }
}

object Money {
  def apply(dollar: Int, cents: Int): Money = new Money(dollar, cents)
}

val m1 = Money(3, 76)
val m2 = Money(1, 25)
val m3 = m1 + m2
m3.dollar
m3.cents
m1 + m2 == Money(5, 1)