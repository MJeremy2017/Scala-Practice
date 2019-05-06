import scala.annotation.switch
import scala.beans.BeanProperty

// @Test class Credential @Inject()(var userName: String)
@transient var a = 1
class P {
  @BeanProperty var name = ""
}

val n = 3
(n: @switch) match {
  case 0 => "Zero"
  case 1 => "One"
  case _ => "?"
}

assert(3 == 3)