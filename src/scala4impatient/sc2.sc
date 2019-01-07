// conditional expressions
val x = 2
val s = if (x>0) 1 else -1

if (x>3) 1 else ()

if (x>0) 1
else if (x==0) 0 else -1

var n = 3
val a = {n -= 1}  // ends with an assignment
val b = {n - 1}

print("answer:", 3)
println("answer:", 3)

printf("%s is %d years old%n", "hh", 33)

val name = "dd"
val age = 22
print(f"$name is $age years old")


//val name2 = io.StdIn.readLine("your name: ")
// readint, byte, short, ...

1 to 10

val ss = "Hello"
var sum = 0
for (i <- 0 to ss.length-1) {
  sum += ss(i)
}
sum

var sum2 = 0
for (ch <- "Hello") sum2 += ch

println(sum2)

for (i <- 1 to 3; j <- 1 to 3 if i != j)
  println(f"${10*i+j}%3d")

// construct a collection of values
for (i <- 1 to 10) yield i % 3

for (c <- "Hello"; i <- 0 to 1) yield (c+i).toChar

for (i <- 0 to 1; c <- "Hello") yield (c+i).toChar

def fac(n: Int) = {
  var r = 1
  for (i <- 1 to n) r *= i
  r
}

def fac2(n: Int): Int = if (n<=0) 1 else n*fac2(n-1)

def sum(args: Int*)={
  var res = 0
  for (arg <- args) res += arg
  res
}

sum(1, 2, 4, 5)

sum(1 to 5: _*)

def recursiveSum(args: Int*) : Int = {
  if (args.length == 0) 0
  else args.head + recursiveSum(args.tail : _*) // _* convert to an argument seq
}






