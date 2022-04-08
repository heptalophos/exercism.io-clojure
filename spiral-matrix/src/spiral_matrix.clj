(ns spiral-matrix)

(defn spiral 
  [n]
  (if (pos? n)
    (->> (range (dec n) 0 -1)
         (mapcat #(repeat 2 %))
         (cons n)
         (mapcat #(repeat %2 %1) (cycle [1 n -1 (- n)]))
         (reductions +)
         (map-indexed vector)
         (sort-by second)
         (map first)
         (map inc)
         (partition n))
    '()))