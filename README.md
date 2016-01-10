# Functional Programming in Scala
## Programming Book Club Toronto

These are my notes and exercises from the book Functional Programming in Scala as part of the series hosted by Programming Book Club Toronto.

Meetup: http://www.meetup.com/Programming-Book-Club-Toronto/events/227066386/

Google Group: https://groups.google.com/forum/#!forum/programming-book-club-toronto

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
