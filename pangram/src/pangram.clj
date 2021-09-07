(ns pangram
  (:require [clojure.string :refer [lower-case]]))

(defn pangram? 
  "determines whether the count of distinct lower-case
   letters in a string is equal to the alphabet length"
  [word]
  (->> word
       lower-case
       (filter #(and (<= (int \a) (int %)) 
                     (>= (int \z) (int %))))
       distinct
       count
       (= 26)))
