val big = BigInt("1232134432134")
big

val x, y = 1
x+y

5%2  // mode

val age = 18

if((age>10) && (age<17)){
  println("yes")
}else{
  println('no)
}

//object increment {
//  def main(args: Array[String]): Unit = {
//    var i = 1
//    while (i <= 10) {
//      println(i)
//      i += 1
//    }
//  }
//}


val l = List(1, 2, 3, 4)
for(i <- l){
  println("Item" + i)
}

var evenList = for {i <- 1 to 20
                    if (i%2)==0} yield i

println(evenList)

println({"dsafsd"})

for (i <- 1 to 3; j <- 3 to 4){
  println(i)
  println(j)
  println()
}

// no break and continue

def prime(): Unit ={
  val l = List(1, 3, 4, 5)

  for(i <- l) {
    if (i == 4){
      return
    }
    println(i)
  }
}

prime()

printf("dsfas %d", 1)

val age1 = 22
val name = "jc"

println(f"Age is {$age1 + 1}")
println(s"Name is $name")

val st = "I am a big fan"
for (s <- st){
  println(s)
}

st + "dsaf"

st.toArray

List(1, 2, 3, 4).map((x: Int) => x*10)

List(1, 2, 3, 4).map(_*10)

List(1, 2, 3, 4).filter(_>3)

println("//////////////////")
def times2(num : Int) = num * 2

println(times2(3))

println("//////////////////")
val anonfunc = (num : Int) => num * 2
anonfunc(3)
anonfunc(4)

class num(var x: Int) {
  var xc = x
  implicit class inc(var b: num) {
    def increase = println(b.xc + 1)
  }
}

//var p = new num(3)
//p.inc

case class Donut(name: String, price: Double, productCode: Option[Long] = None)
val vanillaDonut: Donut = Donut("Vanilla", 1.50)

object DonutImplicits {
  implicit class AugmentedDonut(donut: Donut) {
    def uuid: String = s"${donut.name} - ${donut.productCode.getOrElse(12345)}"
  }
}

import DonutImplicits._
vanillaDonut.uuid

val a = List(1, 2)
3 :: a

for (x <- a) {
  println(x)
}

val b  = Array(1, 2, 3)
b.length