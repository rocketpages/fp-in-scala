import org.fpbct.chapter2._
import org.scalatest.FunSuite

class Chapter2Suite extends FunSuite {

  test("MyModule.abs() positive output for positive input") {
    val abs = MyModule.abs(6)
    assert(abs >= 0)
  }

  test("MyModule.abs() positive output for negative input") {
    val abs = MyModule.abs(-6)
    assert(abs >= 0)
  }

  test("MyModule.abs() positive output for zero") {
    val abs = MyModule.abs(0)
    assert(abs >= 0)
  }

  test("MyModule.formatAbs() is formatted correctly") {
    val formattedAbs: String = MyModule.formatAbs(-6)
    assert(formattedAbs == "The absolute value of -6 is 6")
  }

  test("MyModule.fib() returns 0 for n(1)") {
    assert(0 == MyModule.fib(1))
  }

  test("MyModule.fib() returns 8 for seventh position") {
    assert(8 == MyModule.fib(7))
  }

  test("MyModule.fib() returns correct for first 10 positions") {
    val firstTen = List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34)
    assert(MyModule.fib(1) == firstTen(0))
    assert(MyModule.fib(2) == firstTen(1))
    assert(MyModule.fib(3) == firstTen(2))
    assert(MyModule.fib(4) == firstTen(3))
    assert(MyModule.fib(5) == firstTen(4))
    assert(MyModule.fib(6) == firstTen(5))
    assert(MyModule.fib(7) == firstTen(6))
    assert(MyModule.fib(8) == firstTen(7))
    assert(MyModule.fib(9) == firstTen(8))
    assert(MyModule.fib(10) == firstTen(9))
  }

  test("MyModule.fib() returns 1836311903 for 47th position") {
    assert(MyModule.fib(47) == 1836311903) // we can only compute up to 47th position with Int
  }

  test("HigherOrderFunctions.factorial() of 6 is 720") {
    assert(HigherOrderFunctions.factorial(6) == 720)
  }

  test("HigherOrderFunctions.formatResult() for abs is formatted correctly") {
    val formattedAbs: String = HigherOrderFunctions.formatResult("absolute value", -6, HigherOrderFunctions.abs)
    assert(formattedAbs == "The absolute value of -6 is 6")
  }

  test("HigherOrderFunctions.formatResult() for factorial is formatted correctly") {
    val formattedAbs: String = HigherOrderFunctions.formatResult("factorial", 6, HigherOrderFunctions.factorial)
    assert(formattedAbs == "The factorial of 6 is 720")
  }

  test("HigherOrderFunctions.isSorted() array of 1, 2, 3, 4 is sorted in ascending order") {
    val a = Array[Int](1, 2, 3, 4)
    assert(HigherOrderFunctions.isSorted(a, HigherOrderFunctions.ascending))
  }

  test("HigherOrderFunctions.isSorted() array of 1, 2, 3, 4 is not sorted in ascending order") {
    val a = Array[Int](1, 2, 3, 4)
    assert(HigherOrderFunctions.isSorted(a, HigherOrderFunctions.descending) == false)
  }

  test("HigherOrderFunctions.curry() create a string appender") {
    def blend(a: String, b: String) = a + " blended with " + b
    val x = HigherOrderFunctions.curry(blend)("apple")
    val word = x("orange")
    val word2 = x("mango")
  }

  test("HigherOrderFunctions.compose() composed function values are correct") {
    def double(num: Int): Int = num * 2
    def add3(num: Int): Int = num + 3
    def sub2(num: Int): Int = num - 2

    val doubleAdd3Sub2 = HigherOrderFunctions.compose(sub2, HigherOrderFunctions.compose(add3, double))

    // first element in the list should be 3
    val xs = List(1, 2, 3).map(doubleAdd3Sub2)
    assert(xs(0) == 3)
    assert(xs(1) == 5)
    assert(xs(2) == 7)
  }
}
