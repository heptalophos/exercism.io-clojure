(ns anagram 
  (:require [clojure.string 
             :refer [join lower-case upper-case]]))

(defn- string-sort 
  "Sort a string, not case sensitive"
  [w]
  (join "" (map str (sort (seq (lower-case w))))))

(defn- anagram? 
  "is candidate an anagram of word"
  [word cand]
  (= word (string-sort cand)))

(defn- not-same? 
  "candidate is not the same as the word"
  [word cand]
  (not= word cand))  

(defn not-capital?
  "candidate is not a capital word"
  [word cand]
  (not= word (upper-case cand)))  

(defn anagrams-for
  "returns a list of anagrams of word from word-list"
  [word word-list]
  (let [sorted-anagram (string-sort word)]
  (filter 
      #(and (anagram? sorted-anagram %)
            (not-same? word %)
            (not-capital? word %))
      word-list)))
