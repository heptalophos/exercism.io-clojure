(ns accumulate)

(defn accumulate
  [f xs]
  (let [head (first xs) tail (rest xs)]
    (cond (seq xs)
          (cons (f head) (accumulate f tail))
      :else
          [])))
