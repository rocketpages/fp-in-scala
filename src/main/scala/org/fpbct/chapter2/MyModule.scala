package org.fpbct.chapter2

object MyModule {
  def abs(n: Int): Int = if (n < 0) -n else n

  def formatAbs(x: Int): String = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  /**
    * Get the fibbonaci number at position n
    * @param n 1-based index
    * @return value of fib at position n
    */
  def fib(n: Int): Int = {
    if (n == 1) 0
    else if (n == 2) 1
    else if (n == 3) 1
    else {
      @annotation.tailrec // compile error if not in tail position
      def go(i: Int, previous1: Int, previous2: Int): Int = {
        if (i == n) previous2+previous1
        else go(i+1, previous2, previous2+previous1)
      }
      go(4, 1, 1)
    }
  }
}