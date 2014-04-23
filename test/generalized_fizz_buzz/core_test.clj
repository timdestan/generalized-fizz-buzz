(ns generalized-fizz-buzz.core-test
  (:require [expectations :refer :all]
            [generalized-fizz-buzz.core :refer :all]))

;; Returns empty when called with 0.
(expect '() (fizz-buzz 0 {}))

;; Returns all numbers up to the given number when called with empty map.
(expect '(1 2 3 4 5) (fizz-buzz 5 {}))

;; When number is multiple of a specified factor,
;; returns the word from the factor in place of the number.
(expect '(1 2 "Fizz" 4 5) (fizz-buzz 5 {3 "Fizz"}))

;; When number is multiple of several factors,
;; combines them in increasing numeric order based on their associated numbers.
(expect '(1 "Fizz" "Buzz" "FizzBaz" 5 "FizzBuzz" 7 "FizzBaz" "Buzz" "Fizz" 11 "FizzBuzzBaz")
        (fizz-buzz 12 {2 "Fizz" 3 "Buzz" 4 "Baz"}))
