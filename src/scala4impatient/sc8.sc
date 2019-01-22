import scala.io.Source

val file_path = "/Users/jeremy.zhang/workspace/Github/ScalaPratice/src/scala4impatient/file.txt"

val source = Source.fromFile(file_path, "UTF-8")
source.getLines().toArray
source.getLines().mkString


for (c <- source) println(c)

val contents = source.mkString.split("\\s+")
contents.length
contents(0)
source.close()

val source1 = Source.fromString("Hello World !")
for (s <- source1) println(source1)
source1.close()

import sys.process._

val sh = "ls -al".!
val result = "ls -al".!!

val numPattern = "[0-9]+".r
for (ms <- numPattern.findAllIn("99 bottles, 85"))
  println(ms)

numPattern.replaceFirstIn("99 bottles, 85", "XX")
numPattern.replaceSomeIn("99 bottles, 85",
  m => if (m.matched.toInt % 2 == 0) Some("XX") else None)

