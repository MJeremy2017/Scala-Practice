trait Logger {
  def log(msg: String)
}

trait ConsoleLogger extends Logger {
  override def log(msg: String): Unit = println(msg)
}

class Account {
  private var name = ""
  private var cur_balance: Double = 0
  def this(name: String, balance: Double) {
    this
    this.name = name
    this.cur_balance = if (balance > 0)  balance else 0
  }
  def withdraw(amount: Double) = {cur_balance -= amount}
}

class SavingAccount extends Account with ConsoleLogger{
  var balance: Double = 0
  override def withdraw(amount: Double) = {
    if (amount > balance) log("Insufficient funds")
    else balance -= amount
  }
}

trait TimeLogger extends ConsoleLogger {
  override def log(msg: String): Unit = {
    super.log(s"${java.time.Instant.now()} $msg")
  }
}

trait ShortLogger extends ConsoleLogger {
  override def log(msg: String): Unit = super.log(
    if (msg.length <= 15) msg else s"${msg.substring(0, 12)}")
}

val acct1 = new SavingAccount with TimeLogger with ShortLogger
val acct2 = new SavingAccount with ShortLogger with TimeLogger

acct1.withdraw(10)
acct2.withdraw(10)

trait Logger2 {
  def log(msg: String)
  def warn(msg: String)= println(s"Warn: $msg")
  def severe(msg: String) = println(s"Sever: $msg")
}


abstract class Saving extends Account with Logger2 {
  severe("Insufficient funds")  // call directly
}

trait LogException extends Exception with ConsoleLogger {
  // def log()= log(getMessage)
}

class UnhappyException extends LogException{
  override def getMessage: String = "arggh"
}  // super class is Exception

class Point(private var x: Int, private var y: Int) extends Color {
  def get_x = x
  def get_y = y
  def move(dx: Int, dy: Int) = {
    x += dx
    y += dy
  }

  override def color(c: String) = println(c)
}

trait Color {
  def color(c: String)
}

val p1 = new Point(3, 2)
p1.move(1, 1)
p1.get_x
p1.get_y
p1.color("RED")