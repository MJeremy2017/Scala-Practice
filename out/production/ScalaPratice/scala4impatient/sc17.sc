class Fraction(val num: Int, val den: Int)
object Fraction {
  def apply(num: Int, den: Int): Fraction = new Fraction(num, den)
}

implicit def frac2double(f: Fraction) = f.num*1.0/f.den

3*Fraction(3, 4)  // implicitly convert Fraction to double

// implicit parameters
case class Delimiters(left: String, right: String)
def quote(what: String)(implicit delim: Delimiters) = println(delim.left + what + delim.right)

quote("haha")(Delimiters("{", "}"))

implicit val d: Delimiters = new Delimiters("[", "]")

quote("hhhhh")  // [hhhhh]

def smaller[T <: Ordered[T]](a: T, b: T): T = if (a < b) a else b

def smaller2[T](a: T, b: T)(implicit order: T => Ordered[T]): T =
  if (order(a) < b) a else b  // define a implicit function order

Ordering[Int].compare(3, 2)

class Pair[T : Ordering](first: T, second: T) {
  def smaller(implicit ord: Ordering[T]) = ord.compare(first, second)
}

"Hello" -> 3

implicit class Int2C(x: Int) {
  def +%(y: Double) = x*(1+y)
}

3 +% .5   // new Int2C(3).(+%)(.5)

