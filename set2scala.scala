object set2 extends App {

  // Custom Control Flow Constructs

  def until(b: => Boolean)(body: => Unit): Unit = {
    if(!b) {
      body
      until(b)(body)
    }
  }
  
  // the following prints all values from 1 to 10
  var x: Int = 0
  
  until (x == 10) {
    x = x + 1
    println(x)
  }
  
  // the following does not print anything
  until (x == 10) {
    x = x - 1
    println(x)
  }
}
