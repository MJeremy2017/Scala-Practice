class Fraction(val num: Int, val den: Int)
object Fraction {
  def apply(num: Int, den: Int): Fraction = new Fraction(num, den)
}

implicit def frac2double(f: Fraction) = f.num*1.0/f.den

3*Fraction(3, 4)  // implicitly convert Fraction to double