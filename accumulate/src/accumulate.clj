(ns accumulate)

(defn accumulate
  [f xs]
  (let [head (first xs) tail (rest xs)]
    (cond (not (seq xs))
          []
      :else    
          (cons (f head) (accumulate f tail)))))
