(ns luhn
  (:require [clojure.string :refer [replace]]))

(defn valid? [n]
  (if-let [normal (re-matches #"^\d\d+$" (replace n #" " ""))]
    (->> (map #(Character/digit % 10) (remove #{\space} (str normal)))
         (reverse)
         (map-indexed #(if (odd? %1) 
                           (* 2 %2) 
                           %2))
         (map #(if (> % 9) (- % 9) %))
         (apply +)
         (#(rem % 10))
         (zero?))
    false))



