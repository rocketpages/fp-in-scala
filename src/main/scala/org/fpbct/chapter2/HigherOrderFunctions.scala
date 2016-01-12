package org.fpbct.chapter2

object HigherOrderFunctions {
  def factorial(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, acc: Int): Int = { // recursive function needs return type
      if (n <= 0) acc
      else go(n-1, n*acc)
    }
    go(n, 1)
  }

  def abs(n: Int): Int = if (n < 0) -n else n

  /**
    * @param s english substitute, e.g, "the value of [s] is"
    * @param n number to apply HOF to
    * @param f higher-order function
    * @return
    */
  // arguments have general names because the types are more important
  def formatResult(s: String, n: Int, f: Int => Int): String = {
    val msg = "The %s of %d is %d"
    msg.format(s, n, f(n))
  }

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def go(i: Int): Boolean = {
      if (i >= as.length-1) true
      else !ordered(as(i),as(i+1)) && go(i+1)
    }
    go(0)
  }

  def ascending(x: Int, y: Int): Boolean = if (x > y) true else false
  def descending(x: Int, y: Int): Boolean = if (x < y) true else false

  def partial1[A, B, C](a: A, f: (A,B) => C): B => C =
    (b: B) => f(a, b)

  def curry[A, B, C](f: (A, B) => C): A => (B => C) = a => b => f(a, b)

  def compose[A, B, C](f: B => C, g: A => B): A => C = a => f(g(a))
}
