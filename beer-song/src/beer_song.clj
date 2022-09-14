(ns beer-song
  (:require [clojure.string :refer [join capitalize]]))

(def stanza "%s of beer on the wall, %s of beer.\n%s, %s of beer on the wall.\n")

(defn- premise [x]
  (cond 
      (< x 0) "99 bottles"
      (= x 0) "no more bottles"
      (= x 1) "1 bottle"
   :else 
      (str x " bottles")))

(defn- conclusion [x]
  (cond 
      (= x 0) "Go to the store and buy some more"
      (= x 1) "Take it down and pass it around"
   :else   
      "Take one down and pass it around"))

(defn verse
  "Returns the nth verse of the song."
  [num]
  (format stanza (capitalize (premise num)) 
                 (premise num) 
                 (conclusion num) 
                 (premise (- num 1))))

(defn sing
  "Given a start and an optional end, returns all verses in this interval. 
  If end is not given, the whole song from start is sung."
  ([start]
   (sing start 0))
  ([start end]
   (join "\n" (map verse (reverse (range end (+ start 1)))))))
