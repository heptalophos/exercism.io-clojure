(ns flatten-array
  (:refer-clojure :exclude [flatten]))

(defn flatten 
  [arr]
  (->>
   arr 
   (tree-seq sequential? seq)
   (filter (complement sequential?)) 
   (remove nil?)))
