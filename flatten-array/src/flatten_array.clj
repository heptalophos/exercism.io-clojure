(ns flatten-array
  (:refer-clojure :exclude [flatten]))

(defn flatten 
  [array]
  (->> array 
       (tree-seq sequential? seq)
       (filter (complement sequential?)) 
       (remove nil?)))