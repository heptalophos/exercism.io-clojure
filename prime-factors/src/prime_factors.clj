(ns prime-factors)

(defn of [n] 
  (loop [n n divisor 2 factors []]
    (if (< n 2)
      factors
      (if (= 0 (rem n divisor))
        (recur (/ n divisor) divisor (conj factors divisor))
        (recur n (inc divisor) factors)))))
