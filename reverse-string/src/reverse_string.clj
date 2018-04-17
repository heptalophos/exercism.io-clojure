(ns reverse-string
  ;(:require [clojure.string :as string])
)

(defn reverse-string
  "reverses a string" 
  [input]
  (reduce str (-> input str seq reverse)) 
)
