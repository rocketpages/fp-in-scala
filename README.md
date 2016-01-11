# Functional Programming in Scala
## Programming Book Club Toronto

These are my notes and exercises from the book Functional Programming in Scala as part of the series hosted by Programming Book Club Toronto.

Book: http://www.amazon.ca/Functional-Programming-Scala-Paul-Chiusano/dp/1617290653

Meetup: http://www.meetup.com/Programming-Book-Club-Toronto/events/227066386/

Google Group: https://groups.google.com/forum/#!forum/programming-book-club-toronto

# Part 1

- Organize small functional programs
- Define purely functional data structures
- Handle errors
- Deal with state

## Chapter 1

- What is functional programming?
  - A restriction on how (we write programs) but not what (our programs do)
  - Thinking purely in terms of functions from inputs to outputs
- Purity
  - When is it OK to implement impure functions?
  - 2 + 2 is a pure function
- What is referential transparency? 
- What is the substitution model?
  - Equational reasoning
  - Substituting equals for equals
- What are side effects?
- Non-obvious side effects
  - Throwing an exception
  - Drawing to the screen
- “Functional programmers often speak of implementing programs with a pure core and a thin layer on the outside”
- Talk about naming standards in functional programs
  - If buyCoffee() doesn’t charge the card, what does *buy* actually mean?
  - Can we think of a better way to name buyCoffee()?
- Potentially new Scala terms
  - List.fill
  - unzip
  - groupBy
  - reduce
  - map

## Chapter 2

- Unlearn: most of us are used to thinking of a program as a series of instructions that has an effect
- FP is all about input, output, types; not order of execution and side effects
- HOF (higher order functions)
  - monomorphic
  - polymorphic
- Critical to understand *partial application on page 26* before moving on to further chapters

### Scala
- all expressions produce a result
- no return keyword needed
- Unit is similar to void
- sbt
  - the build tool of Scala
- compilation
  - Scala is typically compiled
  - source file can also be supplied to the interpreter directly, useful for scripting
- Scala REPL is your friend, learn it well!
- 2 + 1 is just syntactic sugar, it's the same as 2.+(1)
  - 2 is an object
  - + is a method on 2
  - 1 is a parameter
  - get comfortable with thinking in terms of combining functions

### Functional loops

- use inner function, called *go* or *loop* by definition
- the arguments to *go* are the state of the loop
- to exit the loop we return a value without calling go
- to continue the loop we pass the current state and invoke go again
- Scala optimizes this using *tail call elimination* if the call to the recursive function is the last thing to do

### HOF (higher order functions)
- functions are values
- pass functions to functions
- HOFs are so general that we use short variable names (e.g, f, g, h), because we don't know what they are aside from type
- monomorphic HOFs are only for a single type (e.g, Int)
- polymorphic (generic) functions are useful for *any* type
  - we need *type parameters* like `def FindFirst[A, B, C](a: A, b: B, c: C)` for generic functions


### Anonymous functions & function literals

- => is a keyword for function literals/anonymous functions
- Heavily used rather for inlining of code when defining polymorphic HOFs
- "Following the types" is the most difficult thing to get used to so far
- Difficut to shake an imperative mindset, that a program is a series of instructions executed in order
  - I found myself struggling to put "order" to the implementation of curry

```scala
// the implementation of the body below is not obvious (dense syntax)
def curry[A, B, C](f: (A, B) => C): A => (B => C) = ???
```

### Examples

```scala
// a function signature that takes a B and returns a C ... anonymous function syntax 
B => C 

// a function signature that takes an A and returns a function that takes a B and returns a C
A => (B => C)

// a more complete anonymous function example
findFirst(Array(1, 5, 9, 12), (x: Int) => x == 9)

//syntactic sugar for object creation
(a, b) => a < b // is the same as below

val lessThan = new Function2[Int, Int, Boolean] { // Function2 takes two inputs and one output
  def apply(a: Int, b: Int) = a < b // construct this new object in order to compute the Boolean
}
```
