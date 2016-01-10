import org.scalatest.FunSuite
import org.fpbct.chapter1._

class Chapter1Suite extends FunSuite {
  test("Cafe.buyCoffee() charge equals price of coffee") {
    val cafe = new Cafe()
    val cc = new CreditCard()
    val (coffee, charge) = cafe.buyCoffee(cc)
    assert(charge.amount == coffee.price)
  }

  test("Cafe.buyCoffees() charge equals price of 6 coffees") {
    val cafe = new Cafe()
    val cc = new CreditCard()
    val (coffees, charge) = cafe.buyCoffees(cc, 6)
    assert(charge.amount == coffees.head.price * 6)
  }

  test("Cafe.coalesce() 4 orders with 3 credit cards results in a list of 3 charges") {
    val cafe = new Cafe()

    // first order
    val cc = new CreditCard()
    val (coffees, charge) = cafe.buyCoffees(cc, 8)

    // second order (same card)
    val (coffees1, charge1) = cafe.buyCoffees(cc, 8)

    // third order
    val cc1 = new CreditCard()
    val (coffees2, charge2) = cafe.buyCoffees(cc1, 2)

    // fourth order
    val cc2 = new CreditCard()
    val (coffees3, charge3) = cafe.buyCoffees(cc2, 2)

    // coalesce all charges into a single charge per unique cc
    assert(cafe.coalesce(List(charge, charge1, charge2, charge3)).size == 3)
  }
}
