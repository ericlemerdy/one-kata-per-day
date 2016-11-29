Data Munging
============

Ref. [Kata04: Data Munging - CodeKata](http://codekata.com/kata/kata04-data-munging/) by Dave Thomas ([@PragDave](https://twitter.com/pragdave))

---

Martin Fowler gave me a hard time for Kata02, complaining that it was yet another single-function, academic exercise.
Which, or course, it was. So this week let's mix things up a bit.

Here’s an exercise in three parts to do with real world data. Try hard not to read ahead—do each part in turn.

## Part One: Weather Data

In [`weather.dat`](./src/test/resources/weather.dat) you’ll find daily weather data for Morristown, NJ for June 2002.
Download this text file, then write a program to output the day number (column one) with the smallest temperature spread
(the maximum temperature is the second column, the minimum the third column).

## Part Two: Soccer League Table

The file [`football.dat`](./src/test/resources/football.dat) contains the results from the English Premier League for
2001/2. The columns labeled `F` and `A` contain the total number of goals scored for and against each team in that
season (so Arsenal scored 79 goals against opponents, and had 36 goals scored against them). Write a program to print
the name of the team with the smallest difference in `for` and `against` goals.

## Part Three: DRY Fusion

Take the two programs written previously and factor out as much common code as possible, leaving you with two smaller
programs and some kind of shared functionality.

## Kata Questions

  - To what extent did the design decisions you made when writing the original programs make it easier or harder to
    factor out common code?

  - Was the way you wrote the second program influenced by writing the first?

  - Is factoring out as much common code as possible always a good thing? Did the readability of the programs suffer
    because of this requirement? How about the maintainability?

