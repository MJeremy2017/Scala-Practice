import java.awt.Point

// object
object Accounts {
  private var lastNum = 0
  def newUniqueNum() = {lastNum += 1; lastNum}
}

//val a1 = Accounts.newUniqueNum()
//val a2 = Accounts.newUniqueNum()

class Accounts {
  val id = Accounts.newUniqueNum()
  private var balance: Double = 0
  def deposit(amount: Double) {balance += amount}
}

val a1 = new Accounts()
a1.id  // 1
val a2 = new Accounts
a2.id  // 2


abstract class UndoableAction(val description: String) {
  def undo(): Unit
  def redo(): Unit
}

object DoNothing extends UndoableAction("Do nothing") {
  override def undo() {}

  override def redo(): Unit = {}

}

DoNothing.redo()

class Account(val id: Int, initBalance: Double) {
  private var balance = initBalance
}

object Account {
  def apply(initBalance2: Double) =
    new Account(1, initBalance2)
}

val acc = Account(100)

// exec without main method
object Hello extends App {
  println("Hello")
}

object Light extends Enumeration {
  val red, yellow, green = Value
}

for (c <- Light.values) println(c.id)

// exercise
object Conversions {
  def inches2centimeters(inch: Double) = 2*inch

  def gallons2liters(gallon: Double) = 3*gallon

  def miles2Kilo(miles: Double) = 4*miles
}

//

abstract class UnitConversion[A] {
  def UnitConversion(unit: A): A
}

object Inch2Centi extends UnitConversion[Double] {
  override def UnitConversion(inch: Double): Double = 2*inch
}

class Point(var x: Int, var y: Int) {

}

object Point {
  def apply(x: Int, y: Int): Point = {
    new Point(x, y)
  }
}

val a = new Point(3, 4)
val aa = Point(3, 4)




