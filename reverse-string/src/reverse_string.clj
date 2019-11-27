(ns reverse-string
  (:require [clojure.string :refer [join]]))

(defn reverse-string
  "reverses a string" 
  [input]
  (join (-> input str seq reverse)))