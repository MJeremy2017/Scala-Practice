class Counter {
  private var value = 0
  def increment() {value += 1}
  def current = value
}

val mC = new Counter
mC.increment()
mC.current

class Person {
  var age = 0
}

val p = new Person
p.age = 12  // setter
p.age  // getter

// redefine getter and setter

class Person2 {
  private var private_age = 0
  def age = private_age
  def age_= (newValue: Int)= {
    if (newValue > private_age) private_age = newValue
  }
}

val fred = new Person2
fred.age = 23
fred.age = 11
println(fred.age)


import scala.beans.BeanProperty

class Person3 {
  @BeanProperty var name: String = _
}

// auxiliary constructor
class Person4 {
  private var age = 0
  private var name = ""

  def this(name: String) {
    this()
    this.name = name
  }

  def this(name: String, age: Int) {
    this(name)
    this.age = age
  }

  def get_name = name
}


val p1 = new Person4("Fred")
p1.get_name
val p2 = new Person4("Fred", 23)

// primary constructor
class Person5(val name: String, val age: Int) {
  println("Person created")
  def description = s"$name is $age"
}

val p3 = new Person5("Fred", 22)
p3.description
p3.name

import scala.collection.mutable.ArrayBuffer

class Network {
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Member]()
  }

  private val members = new ArrayBuffer[Member]()

  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
}

val chatter = new Network
val myFace = new Network

val fred1 = chatter.join("Fred")
val wilma = chatter.join("Wilma")

fred1.contacts += wilma

val barney = myFace.join("Barney")
// fred1.contacts += barney  wrong


class BankAccount {
  private var balance: Double = 0
  def deposit(amount: Double): Unit = {
    balance += amount
  }

  def withdraw(amount: Double): Unit = {
    if (amount <= balance) balance -= amount
  }

  def get_balance = balance

}

val ba = new BankAccount
ba.get_balance


class Time {
  private var hour = 0
  private var minute = 0

  def this(hour: Int, minute: Int) {
    this
    if (hour >= 0 & hour <= 23) this.hour = hour
    if (minute >= 0 & minute <= 60) this.minute = minute
  }

  def get_hour = hour
  def get_minute = minute

  def before(hour: Int, minute: Int): Boolean = {
    val cur_time = 60*this.hour + this.minute
    val time = 60*hour + minute
    time < cur_time
  }
}

val t = new Time(3, 30)
t.before(3, 24)

class A(t: Int) {
  def get_t=t
}

val a = new A(3)
a.get_t

class Person6(private var name: String, private var age: Int) {
  if (age < 0) age = 0
  def this() {
    this("John", 22)
  }
  def get_age = age
}

val p6 = new Person6("Fred", -3)
p6.get_age

val p7 = new Person6
p7.get_age











