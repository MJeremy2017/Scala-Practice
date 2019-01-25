trait Logger {
  def log(msg: String) = println(msg)
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


