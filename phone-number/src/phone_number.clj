(ns phone-number
  (:require [clojure.string :as str]))

(defn number [num-string] 
  (let [ph (str/replace num-string #"\D" ""  )
      length (count ph)]
    (cond 
      (and (= 11 length) (= \1 (first ph))) 
        (subs ph 1)
      (= 10 length) 
        ph 
      :else 
        "0000000000" )))

(defn area-code [num-string] 
  (subs (number num-string) 0 3))

(defn pretty-print [num-string] 
  (let [number (number num-string)]
    (format "(%s) %s-%s" (area-code num-string) 
                         (subs number 3 6) 
                         (subs number 6))))