package fibonacci

/**
 * 递归练习
 */
object FibonacciScala {
  def main(args: Array[String]): Unit = {
    val n = getFibonacci(4)
    println("n=" + n)

    val n1 = f1(2)
    println("n1=" + n1)

    val n2 = f2(1)
    println("猴子吃桃=" + n2)
  }

  /**
   * 猴子吃桃问题
   * f(n) = 2f(n+1)+2
   * f(10)=1
   * @param n
   * @return
   */
  def f2(n: Int): Int = {
    if (n == 10) {
      return 1
    }
    2 * f2(n + 1) + 2
  }


  /**
   * f(x)=2*f(x-1)+1，当x=1时，f(x)=3
   *
   * @param n
   * @return
   */
  def f1(n: Int): Int = {
    if (n == 1) {
      return 3
    }
    2 * f1(n - 1) + 1
  }

  /**
   * 递归实现斐波那契
   *
   * @param n
   * @return
   */
  def getFibonacci(n: Int): Int = {
    if (n == 1 || n == 2) {
      return 1
    }
    getFibonacci(n - 1) + getFibonacci(n - 2)
  }
}
