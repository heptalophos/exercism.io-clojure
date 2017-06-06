(ns word-count)
(require '[clojure.string :as str])

(defn- words[input] ;; create sequence of words out of input string excluding non-alphanumeric characters
  (re-seq #"\w+" input))

(defn- normal [input] ;; and normalise individual words (all letters lowercase)
  (str/lower-case input))

(defn word-count [input] ;; and then count their occurence frequency in the sequence
  ( -> input normal words frequencies ))
