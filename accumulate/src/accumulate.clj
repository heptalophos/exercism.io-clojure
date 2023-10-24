(ns accumulate)

(defn accumulate 
      [f xs]
      (cond (seq xs) 
            (cons (f (first xs)) (accumulate f (rest xs))) 
         :else
            []))
