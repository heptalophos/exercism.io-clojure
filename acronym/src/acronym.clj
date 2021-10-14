(ns acronym
    (:require [clojure.string :refer [join upper-case]]))

(defn acronym 
    [words] 
    (->> words 
         (re-seq #"\p{Upper}*\p{Lower}*")
         (map first)
         (join)
         (upper-case)
    )
)