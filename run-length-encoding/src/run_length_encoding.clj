(ns run-length-encoding)

(defn pack-repeats 
  "packs substrings of repeated characters into a <num><char> substring"
  [coll]
  (if (= (count coll) 1)
    (str (first coll))
    (str (count coll) (first coll))))

(defn run-length-encode
  "encodes a string with rle"
  [s]
  (->> s 
       (partition-by identity)
       (map pack-repeats)
       (apply str))
)

(defn unpack-repeats
  [n c]
  (apply str (repeat n c)) 
)

(defn unpack 
  "unpacks strings like <num><char> into <num>-length sequences of <char>"
  [s]
  (if (Character/isDigit (first s))
    (let [split (split-with #(Character/isDigit %) s)
          num (Integer/parseInt (apply str (first split)))
          ltr (first (second split))]
      (unpack-repeats num ltr)) s)
)

(defn run-length-decode
  "decodes an rle string"
  [s]
  (->> s (re-seq #"\d*\D{1}")
         (map unpack)
         (apply str))
)