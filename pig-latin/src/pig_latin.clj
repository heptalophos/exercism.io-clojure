(ns pig-latin)

(def pattern-v #"([aeiou]|xr|yt).+")
(def pattern-c #"(s?qu|[^aeiou]+)(.+)")

(defn pig-latinize 
    [word]
    (cond 
        (re-matches pattern-v word) 
            (str word "ay")
        (re-matches pattern-c  word) 
            (clojure.string/replace word pattern-c "$2$1ay")
        :else ""))

(defn translate 
    [phrase]
    (->> (clojure.string/split phrase #"\s+")
         (map pig-latinize)
         (clojure.string/join " ")))
