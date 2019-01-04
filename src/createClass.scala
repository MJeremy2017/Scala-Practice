object createClass {
  def main(args: Array[String]): Unit = {
    val rover = new Animal("rover", "woooo")

    rover.setName("whisker")

    println(rover.getName())
    println(rover.getSound())

  }  // END OF MAIN

  class Animal(var name: String, var sound: String) {
    // this.setName(name)
    def getName() : String = name
    def getSound() : String = sound

    def setName(name: String): Unit = {
      this.name = name
    }

    def setSound(sound: String): Unit ={
      this.sound = sound
    }
  }

}
