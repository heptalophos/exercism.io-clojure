(ns phone-number
  (:require [clojure.string :refer [replace]]))

(defn number [num-string] 
  (let [phone (replace num-string #"\D" "")
        length (count phone)]
    (cond 
      (and (= 11 length) (= \1 (first phone))) 
        (subs phone 1)
      (and 
        (= 10 length)
        (and (not= \0 (first (subs phone 0 3))) 
             (not= \1 (first (subs phone 0 3)))) 
        (and (not= \0 (first (subs phone 3 6))) 
             (not= \1 (first (subs phone 3 6))))) 
        phone
      :else 
        "0000000000" )))

(defn area-code [num-string] 
  (subs (number num-string) 0 3))

(defn pretty-print [num-string] 
  (let [number (number num-string)]
    (format "(%s) %s-%s" (area-code num-string) 
                         (subs number 3 6) 
                         (subs number 6))))