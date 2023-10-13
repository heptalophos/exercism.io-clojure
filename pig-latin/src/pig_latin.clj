(ns pig-latin (:require 
               [clojure.string :as s :refer [join split]]))

(def pattern-vowel #"([aeiou]|xr|yt).+")
(def pattern-conso #"(s?qu|rh|[^aeiou]+)(.+)")

(defn pig-latinize 
    [word]
(cond 
    (re-matches pattern-vowel word) (str word "ay")
    (re-matches pattern-conso  word) (s/replace word pattern-conso "$2$1ay")
    :else ""))

(defn translate 
    [phrase]
    (->> (split phrase #"\s+")
         (map pig-latinize)
         (join " ")))
