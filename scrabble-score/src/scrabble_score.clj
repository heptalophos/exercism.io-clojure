(ns scrabble-score)

(def scores { "AEIOULNRST" 1
              "DG" 2
              "BCMP" 3
              "FHVWY" 4
              "K" 5
              "JX" 8
              "QZ" 10
            })

(defn- pairwise
  [pairs letters score]
  (conj pairs (reduce
                (fn [a letter] (conj a [letter score]))
                []
                letters)))


(def score
  (into {} (apply concat (reduce-kv pairwise [] scores))))


(defn score-letter [letter]
  (score (clojure.string/upper-case letter)))


(defn score-word  [word]
  (reduce + 0 (map score-letter word)))

