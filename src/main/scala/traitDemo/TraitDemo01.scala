package traitDemo

/**
 * 抽象类、trait、函数式编程的简单结合使用
 */
object TraitDemo01 {
  def main(args: Array[String]): Unit = {
    val richStringIter = new RichStringIter("scala")
    richStringIter.foreach(println)
  }
}

abstract class AbsIterator {
  type T
  def hasNext: Boolean
  def next(): T
}

class StringIterator(s: String) extends AbsIterator {
  type T = Char
  private var i = 0
  def hasNext = i < s.length
  def next() = {
    val ch = s charAt i
    i += 1
    ch
  }
}

trait RichIterator extends AbsIterator {
  def foreach(f: T => Unit): Unit = while (hasNext) f(next())
}

class RichStringIter(s:String) extends StringIterator(s) with RichIterator{}
