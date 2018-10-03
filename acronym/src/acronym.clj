(ns acronym)

(defn acronym [words] 
    (->> words 
         (re-seq #"\p{Upper}*\p{Lower}*")
         (map first)
         (clojure.string/join)
         (clojure.string/upper-case)))