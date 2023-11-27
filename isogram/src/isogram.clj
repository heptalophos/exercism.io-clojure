(ns isogram
    (:require [clojure.string :refer [lower-case]]))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn isogram? 
    [sentence] 
    (->> sentence 
         (lower-case)
         (re-seq #"(?U)\p{Alpha}")
         (apply distinct?)))
