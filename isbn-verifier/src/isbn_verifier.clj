(ns isbn-verifier
  (:require [clojure.string :as s]))

(defn isbn? [isbn]
  (-> (some->> (s/replace isbn "-" "")
               (re-matches #"^\d{9}[\dX]$")
               (map (fn [_] (if (= \X _) 
                                10
                                (Character/digit _ 10))))
               (map (fn [n _] (* n _)) (range 10 0 -1))
               (reduce +)
               (#(mod % 11))
               (zero?))
      boolean))