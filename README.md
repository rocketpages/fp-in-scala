# Functional Programming in Scala
## Programming Book Club Toronto

These are my notes and exercises from the book Functional Programming in Scala as part of the series hosted by Programming Book Club Toronto.

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

### Anonymous functions & function literals

- => is a keyword for function literals/anonymous functions
- Heavily used rather for inlining of code when defining polymorphic HOFs

### Challenges
  
- Very difficult to think in terms of types coming from a Java background, for instance...

```scala
// the implementation of the body below is not obvious (dense syntax)
def curry[A, B, C](f: (A, B) => C): A => (B => C) = ???
```

- Very important to learn how to "follow the types", but difficut to shake an imperative mindset

### Examples

- Function literal syntax is the most important takeaway from the chapter
- Much more difficult than HOFs

```scala
// a function signature that takes a B and returns a C ... anonymous function syntax 
B => C 

// a function signature that takes an A and returns a function that takes a B and returns a C
A => (B => C)
```
