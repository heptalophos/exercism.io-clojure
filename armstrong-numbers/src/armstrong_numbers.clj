(ns armstrong-numbers)

(defn- ** 
  "Returns the (integer) nth-power of x"
  [x n] 
  (->> x (repeat n) 
         (reduce *)))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn armstrong?
  "Checks if num is an armstrong 
   (or narcissistic) number"
  [num]
  (->> num (str) 
           (seq) 
           (map (fn [d] (Character/digit d 10)))
           (map (fn [x] (** x (count (str num))))) 
           (reduce +)
           (= num)))