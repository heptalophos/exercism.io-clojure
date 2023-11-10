(ns nth-prime)

;; Using the previously solved sieve exercise

(def ^:private certainty 7) ;; To get a 99.22% probabilty of primality

;; The efficient Miller-Rabin implementation in Java's BigInteger#isProbablePrime
(defn- prime?
    "Determine primality of n. The Miller-Rabin certainty parameter is used to 
     calculate the probability of a number being prime: (1 - (1 / 2 ** certainty))"
    [n]
    (.isProbablePrime (BigInteger/valueOf n) certainty))

;; A closed form approximation of n*ln(n)
(defn- theoretical-limit
    [n]  
    (+ 2 (int (* 4/3 n (Math/log n)))))

(defn sieve 
    [limit] 
    (->> limit inc (range 2) (filter prime?)))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn nth-prime
    [n]
    (if (< n 1)
      (throw (IllegalArgumentException.))
      (->> n (+ 2) theoretical-limit sieve (drop (dec n)) first)))