(ns generalized-fizz-buzz.core
  (:gen-class))

;; Range from 1 to n
(defn one-to [n] (take n (iterate inc 1)))

;; Returns true iff the factor divides n.
(defn divides [factor n] (= 0 (mod n factor)))

;; Generates the word or number for n given the provided factors.
(defn number-or-word [n factors]
  (let [matchingFactors
        (for [factor factors
              :let [f' (key factor)
                    word (val factor)]
              :when (divides f' n)]
          word)]
    (if (empty? matchingFactors)
      n
      (apply str matchingFactors))))

;; Generates a sequence from 1 to n, modified based on factors.
(defn fizz-buzz [n factors]
  (map (fn [n'] (number-or-word n' factors)) (one-to n)))
