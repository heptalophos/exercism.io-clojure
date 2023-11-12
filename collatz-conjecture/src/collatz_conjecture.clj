(ns collatz-conjecture)

(defn collatz 
  [n] 
  (letfn [(collatz ;; recurrence 
            [n]
            (cond 
              (= n 1) 1
              (even? n) (bit-shift-right n 1)
              :else (inc (* 3 n))))]
  (if (> n 0) 
    (count (take-while (fn [_] (not= 1 _)) (iterate collatz n)))
    (throw (IllegalArgumentException. "number must be positive")))))