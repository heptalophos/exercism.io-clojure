(ns run-length-encoding)

(defn- pack-repeats 
  "packs substrings of a repeated character into a 
   substring consisting of the count of occurences
   of the character followed by the character. 
   Example: AAAAA -> 5A "
  [coll]
  (if (= (count coll) 1)
    (str (first coll))
    (str (count coll) (first coll))))

(defn- unpack-repeats 
  "unpacks a substring consisting of a number n and a character 
   into a substring of the character repeated n times "
  [s]
  (if (Character/isDigit (first s))
    (let [split (split-with #(Character/isDigit %) s)
          num (Integer/parseInt (apply str (first split)))
          chr (first (second split))]
      (apply str (repeat num chr))) s))

(defn run-length-encode
  "encodes a string with rle"
  [s]
  (->> s 
       (partition-by identity)
       (map pack-repeats)
       (apply str)))

(defn run-length-decode
  "decodes an rle string"
  [s]
  (->> s (re-seq #"\d*\D{1}")
         (map unpack-repeats)
         (apply str)))