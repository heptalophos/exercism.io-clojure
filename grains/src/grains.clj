(ns grains)

(defn- exp 
    [x n]
  (reduce * (repeat n (bigint x))))

(defn square 
    [n]
    (exp 2 (dec n)))

(defn total 
    []
    (dec (square 65)))