(ns spiral-matrix)

(defn spiral 
  [n]
  (if (> n 0)
    (->> (range (dec n) 0 -1)
         (mapcat (fn [_] (repeat 2 _)))
         (cons n)
         (mapcat (fn [_ x] (repeat x _)) 
                 (cycle [1 n -1 (- n)]))
         (reductions +)
         (map-indexed vector)
         (sort-by second)
         (map first)
         (map inc)
         (partition n))
    '()
  ))