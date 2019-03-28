(ns octal)

(defn to-decimal
  [input]
  (if (re-matches #"[0-7]+" input)
    (->> (reverse input)
         (map #(Character/getNumericValue %1))
         (map * (iterate (partial * 8) 1))
         (reduce + 0))
    0))