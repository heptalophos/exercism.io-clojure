(ns nth-prime)

;; Using the previously solved sieve exercise

(defn- prime?
  [n]
  (empty? (filter #(zero? (mod n %)) (range 2 n))))

(defn- theoretical-limit
  [n]  ;; closed form approximation of n*ln(n)
  (+ 2 (int (* 4/3 n (Math/log n)))))

(defn sieve 
  [limit] 
  (->> limit
       inc
       (range 2)
       (filter prime?)))

(defn nth-prime 
  [n]
  (if (< n 1) (throw (IllegalArgumentException.)))
  (->> n 
       (+ 2)
       theoretical-limit
       sieve
       (drop (dec n))
       first))