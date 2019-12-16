(ns pangram
  (:require [clojure.string :refer [lower-case]]))

(defn pangram? 
  [word]
  (->> word
       lower-case
       (filter #(and (<= (int \a) (int %)) 
                     (>= (int \z) (int %))))
       distinct
       count
       (= 26)))
