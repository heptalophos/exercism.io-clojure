(ns accumulate)

(defn accumulate 
      [f xs]
      (if (seq xs)
          (cons 
              (f (first xs))
              (accumulate f (rest xs))) 
          []))
