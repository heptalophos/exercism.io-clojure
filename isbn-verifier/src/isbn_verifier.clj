(ns isbn-verifier
  (:require [clojure.string :as s]))

(defn isbn? [isbn]
  (-> (some->> (s/replace isbn "-" "")
               (re-matches #"^\d{9}[\dX]$")
               (map (fn [c] (if (= \X c) 10 (Character/digit c 10))))
               (map (fn [n c] (* n c)) (range 10 0 -1))
               (apply +)
               (#(mod % 11))
               zero?)
      boolean))