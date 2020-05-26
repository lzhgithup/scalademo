package namedArgument

/**
 * 带名参数
 */
object NamedArgument {

  def main(args: Array[String]): Unit = {
    //printName(last = "bob","aby") //若未指定参数名进行赋值，则必须按照方法签名中参数的声明顺序赋值
    printName("aby", last = "bob")
  }

  def printName(first: String, last: String): Unit = {
    println(first + " " + last)
  }
}
