(ns collatz-conjecture)

(defn collatz 
  [n] 
  (letfn [(collatz ;; recurrence 
            [n]
            (cond 
                  (= n 1) 1
                  (even? n) (/ n 2)
                  :else (inc (* n 3))))]
  (if (> n 0) 
    (count (take-while #(not= 1 %) (iterate collatz n)))
    (throw (IllegalArgumentException. "number must be positive")))))