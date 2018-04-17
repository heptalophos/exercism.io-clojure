(ns anagram 
  (:require [clojure.string :refer [join lower-case upper-case]]))

(defn string-sort 
  "Sort a string"
  [w]
  (join "" (map str (sort (seq (lower-case w)))))
)

(defn anagram? 
  "compute if candidate is anagram of word"
  [word cand]
  (= word (string-sort cand))
)

(defn not-same? 
  "compute if candidate is not the same as the word"
  [word cand]
  (not= word cand)  
)  

(defn not-capital?
  "candidate is not a capital word"
  [word cand]
  (not= word (upper-case cand))  
)  

(defn anagrams-for
  "words list from words that are anagram with anagram"
  [anagram word-list]
  (let [sorted-anagram (string-sort anagram)]
  (filter 
    #(and (anagram? sorted-anagram %)
          (not-same? anagram %)
          (not-capital? anagram %))
  word-list) ))