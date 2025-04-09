(ns perfect-numbers)
  
(defn- factors
    "Returns a list of all the proper factors of n."
    [n]
    (for [x (range 1 (inc (quot n 2))) 
          :when (zero? (rem n x))] x))

(defn classify
    "Determines the perfectness of a number using its aliquot sum"
    [n]
    (let [sum (reduce + (factors n))]
        (when (neg? n) (throw (IllegalArgumentException.)))
        (cond
            (> sum n) :abundant
            (< sum n) :deficient
            (= sum n) :perfect
            :else :unclassifiable)))
