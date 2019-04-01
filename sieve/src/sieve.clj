(ns sieve)

(defn- prime?
  [num]
  (empty? (filter #(zero? (mod num %)) (range 2 num))))

(defn sieve 
  [limit] 
  (->> limit
       inc
       (range 2)
       (filter prime?)))
