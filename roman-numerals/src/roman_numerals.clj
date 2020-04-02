(ns roman-numerals
      (:require [clojure.string :refer [join]]))

(def roman-map {
                1000 "M" 900 "CM" 500 "D" 400 "CD" 
                100  "C" 90  "XC" 50  "L" 40  "XL" 
                10   "X" 9   "IX" 5   "V" 4   "IV" 
                1 "I"
               })

(defn numerals [arabic]
  (loop [roman "" remainder arabic]
      (if (zero? remainder)
            roman
            (let [next (apply max 
                              (filter #(>= remainder %) 
                              (keys roman-map)))]
            (recur (join "" [roman (roman-map next)]) 
                   (- remainder next))))))


; Of course, there is also a trivial way to do it:
; (ns roman-numerals
;       (:require [clojure.pprint :refer [cl-format]]))

; (defn numerals [n] 
;       (cl-format nil "~@R" n))
