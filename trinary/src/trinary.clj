(ns trinary)

(defn to-decimal
  [input]
  (->> (reverse input)
       (filter #(or (= \0 %1) (= \1 %1) (= \2 %1)))
       (map-indexed #(if (= %2 \2) (Math/pow 3 %1) (if (= %2 \1) (Math/pow 3 %1) 0)))
       (reduce + 0)
       (int)))
