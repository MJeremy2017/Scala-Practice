import scala.io.Source

val file_path = "/Users/jeremy.zhang/workspace/Github/ScalaPratice/src/scala4impatient/file.txt"

val source = Source.fromFile(file_path, "UTF-8")
source.getLines().toArray
source.getLines().mkString

source.close()