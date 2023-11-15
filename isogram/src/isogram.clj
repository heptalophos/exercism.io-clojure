(ns isogram
    (:require [clojure.string :refer [lower-case]]))

(defn isogram? 
    [sentence] 
    (->> sentence 
         (lower-case)
         (re-seq #"(?U)\p{Alpha}")
         (apply distinct?)))
