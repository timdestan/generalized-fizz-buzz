(ns generalized-fizz-buzz.core
  (:gen-class))

;; Range from 1 to n
(defn one-to [n] (take n (iterate inc 1)))

;; Returns true iff the factor divides n.
(defn divides [factor n] (= 0 (mod n factor)))

;; Finds words that are associated with a multiple
;; of n in the factors.
(defn words-for-multiples [n factors]
  (for [factor factors
              :let [n' (key factor)
                    word (val factor)]
              :when (divides n' n)]
          word))

;; Generates the word or number for n given the provided factors.
(defn number-or-word [n factors]
  (let [words (words-for-multiples n factors)]
    (if (empty? words) n (apply str words))))

;; Generates a sequence from 1 to n, modified based on factors.
(defn fizz-buzz [n factors]
  (map (fn [n'] (number-or-word n' factors)) (one-to n)))

;; Print out the results up to 100.
(defn -main []
  (doall (map println (fizz-buzz 100 {3 "Fizz" 5 "Buzz" 7 "Baz"}))))
