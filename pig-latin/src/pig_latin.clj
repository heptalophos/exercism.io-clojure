(ns pig-latin 
    (:require [clojure.string 
               :refer [join replace split]]))

(def pattern-vowel #"([aeiou]|xr|yt).+")
(def pattern-conso #"(s?qu|[^aeiou]+)(.+)")

(defn pig-latinize 
    [word]
(cond 
    (re-matches pattern-vowel word) 
        (str word "ay")
    (re-matches pattern-conso  word) 
        (replace word pattern-conso "$2$1ay")
    :else ""))

(defn translate 
    [phrase]
    (->> (split phrase #"\s+")
         (map pig-latinize)
         (join " ")))
