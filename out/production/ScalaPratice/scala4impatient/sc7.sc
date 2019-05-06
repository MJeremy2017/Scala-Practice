class Person(val name: String, val age: Int) {
  override def toString: String = s"${getClass.getName}[name=$name]"
  def id = -1
}

val p = new Person("Fred", 22)
p.name
p.age
p.toString

class Employee(emp_name: String, age: Int, salary: Double) extends Person(emp_name: String, age: Int) {
  override val name: String = "secret"
  override val toString = " "
}

val ep = new Employee("Aa", 22, 33.2)
ep.name

class Student(name: String, age: Int, override val id: Int) extends Person(name: String, age: Int)

val st = new Student("f", 22, 3)
// val can override both val and def
// var can only override abstract var

val a: Int = 0
a.getClass
st.getClass

class Item(val description: String, val price: Double) {
  override def equals(other: Any): Boolean = {
    other match {
      case a: Item => description==a.description && price==a.price
      case _ => false
    }
  }
}
//
//class MillTime(val time: Int) extends AnyVal {
//  def hour = time/100
//  def minute = time % 100
//
//  override def toString: String = f"$time"
//}

// val mt = new MillTime(123)


class BankAccount(initialBalance: Double) {
  private var balance = initialBalance
  def currentBalance = balance
  def deposit(amount: Double) = { balance += amount; balance }
  def withdraw(amount: Double) = { balance -= amount; balance }
}

val ba = new BankAccount(100)

class CheckingAccount(initialB: Double) extends BankAccount(initialB: Double) {
  private var balance = initialB
  override def deposit(amount: Double): Double = {
    balance = balance + amount -1
    balance
  }

  override def withdraw(amount: Double): Double = {
    balance = balance - amount -1
    balance
  }

  override def currentBalance: Double = balance
}

val ba2 = new CheckingAccount(100)
ba2.deposit(10)  // 109
ba2.currentBalance

class SavingAccount(balance: Double) extends BankAccount(balance) {
  private var cur_balance = balance
  def monthlyInterest = {
    cur_balance *= 1.2
    cur_balance
  }

  override def currentBalance: Double = cur_balance
}

val sa = new SavingAccount(10)
sa.currentBalance  // 10
sa.monthlyInterest  // 12
sa.currentBalance  // 12

abstract class Item2 {
  val a = 1
  def description: String
  def price: Double
}

class SimpleItem(override val description: String, override val price: Double) extends Item2

val si = new SimpleItem("apple", 3)
si.description



class BundleItems(descriptions: List[String], prices: List[Double]) extends Item2 {
  val innera = a
  override def description: String = {
    descriptions.mkString(" and ")
  }

  override def price: Double = {
    prices.sum
  }
}

val bl = new BundleItems(List("apple", "pear"), List(3, 2))
bl.innera
bl.description
bl.price

class Point(x: Int, y: Int) {
  override def toString: String = s"$x, $y"
}

class LabelPoint(label: String, x:Int, y:Int) extends Point(x: Int, y: Int)

val p1 = new Point(3, 2)
println(p1)
