(ns reverse-string
  (:require [clojure.string :refer [join]]))

(defn reverse-string
  "reverses a string in place" 
  [input]
  (->> input str seq (into ()) join))