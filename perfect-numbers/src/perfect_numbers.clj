(ns perfect-numbers)

(defn- factors 
      [n]
      (for [x (range 2 (inc (quot n 2))) :when (zero? (rem n x))] x))

(defn classify 
      [n]
      (when (neg? n) (throw (IllegalArgumentException. "Invalid Argument!")))
      (def sum (reduce + 1 (factors n)))
      (cond
        (= sum n) :perfect
        (> sum n) :abundant
        :else :deficient)) 
