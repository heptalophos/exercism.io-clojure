(ns spiral-matrix)

(defn spiral [n]
  (if (pos? n)
    (partition n 
               (map inc 
                    (map first 
                         (sort-by second 
                                  (map-indexed vector
                                               (reductions + 
                                                           (mapcat #(repeat %2 %1) (cycle [1 n -1 (- n)])
                                                                   cons n 
                                                                   (mapcat #(repeat 2 %) 
                                                                           (range (dec n) 0 -1))))))))
    '())))