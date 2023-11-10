(ns crypto-square 
  (:require [clojure.string :refer [join lower-case]]))

(defn- sanitize
  [text]
  (->> text (lower-case) (filter (fn [_] (Character/isLetterOrDigit _)))))

(defn normalize-plaintext 
  [text]
  (->> text (sanitize) (join)))

(defn square-size 
  [text]
  (->> text (sanitize) (count) (Math/sqrt) (Math/ceil) (int)))

(defn plaintext-segments 
  [text]
  (let [size (square-size text)] 
  (->> text (sanitize) (partition size size nil) (map (partial apply str)))))

(defn- chunkify
  [text padder]
  (let [chunks (-> text plaintext-segments)
        rs (-> chunks first count)
        padding (fn [_] (concat _ (take (- rs (count _)) (repeat padder))))]
  (map padding chunks)))

(defn ciphertext 
  [text]
  (->>  (chunkify text nil) (apply mapcat vector) (reduce str)))

(defn normalize-ciphertext 
  [text]
  (->>  (chunkify text \space) 
        (apply map vector) 
        (map (partial reduce str))
        (join \space)))
