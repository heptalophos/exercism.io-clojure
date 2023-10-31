(ns anagram 
  (:require [clojure.string 
             :refer [join lower-case upper-case]]))

(defn- string-sort 
  "Sort a string, not case sensitive"
  [w]
  (join "" (map str (sort (seq (lower-case w))))))

(defn- anagram? 
  "is candidateidate an anagram of word"
  [word candidate]
  (= word (string-sort candidate)))

(defn- not-same? 
  "candidateidate is not the same as the word"
  [word candidate]
  (not= word candidate))

(defn not-capital?
  "candidateidate is not a capital word"
  [word candidate]
  (not= word (upper-case candidate)))  

(defn anagrams-for
  "returns a list of anagrams of word from word-list"
  [word word-list]
  (let [sorted-anagram (string-sort word)]
    (filter (fn [w] (and (anagram? sorted-anagram w)
                         (not-same? word w)
                         (not-capital? word w)))
            word-list)))