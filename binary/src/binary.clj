(ns binary)

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn to-decimal 
    [input-string]
    (->> (reverse input-string)
         (filter (fn [_] (or (= _ \0) (= _ \1))))
         (map-indexed (fn [x y] (if (= y \1) (Math/pow 2 x) 0)))
         (apply + 0)
         (int)))
