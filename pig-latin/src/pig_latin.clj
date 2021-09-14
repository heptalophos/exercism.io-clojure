(ns pig-latin 
    (:require [clojure.string :as s]))

(def pattern-vowel #"([aeiou]|xr|yt).+")
(def pattern-conso #"(s?qu|[^aeiou]+)(.+)")

(defn pig-latinize 
    [word]
(cond 
    (re-matches pattern-vowel word) 
        (str word "ay")
    (re-matches pattern-conso  word) 
        (s/replace word pattern-conso "$2$1ay")
    :else ""))

(defn translate 
    [phrase]
    (->> (s/split phrase #"\s+")
         (map pig-latinize)
         (s/join " ")))
