package org.fpbct.chapter1

class Cafe {
  // emit the charge seperate from a coffee
  def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
    val cup = new Coffee()
    (cup, Charge(cc, cup.price))
  }

  // emit coffees (plural) and a single charge for all coffees
  def buyCoffees(cc: CreditCard, n: Int): (List[Coffee], Charge) = {
    val purchases: List[(Coffee, Charge)] = List.fill(n)(buyCoffee(cc)) // fill(n) inits the list using buyCoffee n number of times, basically a list of tuples
    val (coffees, charges) = purchases.unzip // pull apart the list of tuples into two lists
    (coffees, charges.reduce((c1, c2) => c1.combine(c2))) // return a list and a single charge
  }

  def coalesce(charges: List[Charge]): List[Charge] = {
    // TODO: discuss how groupBy works
    charges.groupBy(_.cc).values.map(_.reduce(_ combine _)).toList
  }
}

case class Charge(cc: CreditCard, amount: Double) {
  def combine(other: Charge): Charge = {
    if (cc == other.cc)
      Charge(cc, amount + other.amount)
    else
      throw new Exception("can't combine charges")
  }
}

// This implementation doesn't even care what the CreditCard is
class CreditCard {}

// Coffee only needs a price
class Coffee {
  val price = 1
}
