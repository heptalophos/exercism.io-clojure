(ns binary)

(defn to-decimal 
    [input-string]
    (->> (reverse input-string)
         (filter #(or (= \0 %1) (= \1 %1)))
         (map-indexed #(if (= %2 \1) (Math/pow 2 %1) 0))
         (reduce + 0)
         (int)))
