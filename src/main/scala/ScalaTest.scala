object ScalaTest {
  def main(args: Array[String]): Unit = {
    println("sadasd")

    val f1 = () => 34
    println(f1) // ScalaTest$$$Lambda$3/401424608@50675690 函数内存地址
    println(f1()) // 34
  }
}
