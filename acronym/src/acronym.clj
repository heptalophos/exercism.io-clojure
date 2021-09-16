(ns acronym
    (:require [clojure.string 
               :refer [join upper-case]]))

(defn acronym 
    [words] 
    (->> words 
         (re-seq #"[A-Z]*[a-z]*")
         (map first)
         (join)
         (upper-case)))