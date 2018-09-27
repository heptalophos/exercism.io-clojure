(ns isogram)

(defn isogram? 
    [sentence] 
    (->> sentence 
         clojure.string/lower-case
         (re-seq #"(?U)\p{Alpha}")
         (apply distinct?)))
