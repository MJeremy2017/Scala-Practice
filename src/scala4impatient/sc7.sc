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
