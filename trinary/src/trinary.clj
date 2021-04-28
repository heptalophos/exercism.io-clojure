(ns trinary)

(defn to-decimal
  [input] 
  (if (re-matches #"[0-2]+" input)
      (->> (reverse input)
           (map #(Character/getNumericValue %1))
           (map * (iterate (partial * 3) 1))
           (reduce + 0))
      0))