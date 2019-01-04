package practice

object rational {

  def main(args: Array[String]): Unit = {
    val x = new  Rational(1, 2)

    val y = new  Rational(3, 4)

    x add y
    x.add(y)
    x.neg
    x.sub(y)
    x.less(y)
    x.max(y)

    new Rational(2)
  }
}


class Rational(x:Int, y:Int) {  // primary constructor
  require(y != 0, "No zero value accepted")

  def this(x: Int) = this(x, 1)

  private def gcd(a:Int, b:Int): Int = if (b==0) a else gcd(b, a%b)
  private val g = gcd(x, y)
  def numer = x/g
  def denom = y/g

  def add(that: Rational) ={
    new Rational(this.numer * that.denom + that.numer*denom, denom*that.denom)
  }

  def less(that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (less(that)) that else this

  override def toString: String = {
    numer + "/" + denom
  }

  def neg = new Rational(-numer, denom)

  def sub(that: Rational) = add(that.neg)
}
