(ns pig-latin)

(defn pig-latinize 
    [word]
    (cond 
        (re-matches #"([aeiou]|xr|yt).+" word) (str word "ay")
        (re-matches #"(s?qu|[^aeiou]+)(.+)"  word) 
            (clojure.string/replace word #"(s?qu|[^aeiou]+)(.+)" "$2$1ay")))

(defn translate 
    [phrase]
    (->> (clojure.string/split phrase #"\s+")
         (map pig-latinize)
         (clojure.string/join " ")))
