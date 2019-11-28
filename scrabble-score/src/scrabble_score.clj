(ns scrabble-score
  (:require [clojure.string :refer [upper-case]]))

(def values { 1 "AEIOULNRST"
              2 "DG"
              3 "BCMP"
              4 "FHVWY"
              5 "K"
              8 "JX"
              10 "QZ"
            })

(def scores
  (into {} (for [[value letters] values letter letters]
                  [letter value])))

(defn score-letter 
  [letter]
  (get scores letter 1))

(defn score-word 
  [word]
  (->> word
       upper-case
       (map scores)
       (reduce +)))
