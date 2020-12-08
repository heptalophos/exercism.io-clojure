(ns word-count)
(require '[clojure.string :refer [lower-case]])

;; create sequence of words out of input string 
;; excluding non-alphanumeric characters
(defn- words 
  [input] 
  (re-seq #"\w+" input))

;; and normalise individual words (all letters lowercase)
(defn- normalized 
  [input] 
  (lower-case input))

;; and then count their occurence frequency in the sequence
(defn word-count 
  [input] 
  (-> input 
      normalized
      words
      frequencies))