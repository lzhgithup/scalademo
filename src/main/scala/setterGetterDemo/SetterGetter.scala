package setterGetterDemo

/**
 * Scala's special syntax for setter and getter
 */
object SetterGetter {
  def main(args: Array[String]): Unit = {
    val point1 = new Point
    //setter
    point1.x = 99
    //getter
    println(point1.x)
    //setter
    point1.y = 101 // prints the warning
  }
}

class Point {
  private var _x = 0
  private var _y = 0
  private val bound = 100

  //getter
  def x = _x
  //setter
  def x_= (newValue: Int): Unit = {
    if (newValue < bound) _x = newValue else printWarning
  }

  def y = _y
  def y_= (newValue: Int): Unit = {
    if (newValue < bound) _y = newValue else printWarning
  }

  private def printWarning = println("WARNING: Out of bounds")
}
