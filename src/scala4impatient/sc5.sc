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



