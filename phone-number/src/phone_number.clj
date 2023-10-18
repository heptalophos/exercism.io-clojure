(ns phone-number
  (:require [clojure.string :refer [replace]]))

(def ^:const invalid "0000000000")

(defn number [num-string] 
  {:pre [(string? num-string)]}
  (let [phone (replace num-string #"\D" "")
        length (count phone)]
    (cond 
      (and (< 11 length)
           (= \+ (first phone))
           (= \1 (first phone)))
      (subs phone 2)
      (and (= 11 length)
           (= \1 (first phone))
           (not (= \0 (first (subs phone 1))))
           (not (= \1 (first (subs phone 1))))
           (not (= \0 (first (subs phone 4))))
           (not (= \1 (first (subs phone 4)))))
        (subs phone 1)
      (and (= 10 length)
           (and (not= \0 (first (subs phone 0 3)))
                (not= \1 (first (subs phone 0 3))))
           (and (not= \0 (first (subs phone 3 6)))
                (not= \1 (first (subs phone 3 6)))))
        phone
      :else
        invalid)))

(defn area-code [num-string] 
  (subs (number num-string) 0 3))

(defn pretty-print [num-string] 
  (let [number (number num-string)]
    (format "(%s) %s-%s" (area-code num-string) 
                         (subs number 3 6) 
                         (subs number 6))))