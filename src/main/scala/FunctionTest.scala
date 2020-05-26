/**
 * 方法与函数几乎等价，只是从范式上来看是不同的
 */
object FunctionTest {
  def main(args: Array[String]): Unit = {
    //调用方法
    val test01 = new Test01
    println("sum=" + test01.getSum(50,90))
    //方法转函数
    val f1 = test01.getSum _
    println("f1=" + f1)
    println("f1Sum=" + f1(30,20))
    //定义函数并调用
    val f2 = (n1:Int,n2:Int) => {
      n1 + n2
    }
    println("f2=" + f2)
    println("f2Sum=" + f2(50,30))
  }
}

class Test01 {
  //方法
  def getSum(n1: Int, n2: Int): Int = {
    n1 + n2
  }
}
