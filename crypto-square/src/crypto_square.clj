(ns crypto-square 
  (:require [clojure.string 
             :refer [split join lower-case replace]]))

(defn- sanitize-plaintext
  [plaintext]
  (->> plaintext
       (lower-case)
       (filter #(. Character isLetterOrDigit %))
  )
)

(defn normalize-plaintext 
  [plaintext]
  (->> plaintext
       (sanitize-plaintext)
       (apply str)
  )
)

(defn square-size 
  [plaintext]
  (->> plaintext
       (normalize-plaintext)
       (count)
       (Math/sqrt)
       (Math/ceil)
       int
  )
)

(defn plaintext-segments 
  [plaintext] 
  (let [normal (normalize-plaintext plaintext)
        sqsize (square-size normal)]
   (into [] (map join (partition sqsize sqsize (repeat " ") normal)))
  )
)

(defn ciphertext 
  [plaintext]
  (let [normal (normalize-plaintext plaintext)
        sqsize (square-size normal)]
    (->> (for [x (range sqsize)]
              (take-nth sqsize (drop x normal)))
         (map join)
         (join " "))
  )
  ;; your code goes here
)

(defn normalize-ciphertext 
  [ciphertext] 
  (replace (normalize-ciphertext ciphertext) #"\s" "")
  ;; your code goes here
)
