(ns atbash-cipher
  (:require [clojure.string 
             :refer [join lower-case replace]]))

(def encipher 
  (let [alpha "abcdefghijklmnopqrstuvwxyz"
        numeric "0123456789"]
    (merge (zipmap numeric numeric)
           (zipmap alpha (reverse alpha)))))         

(defn encode 
    [plain] 
    (let [chunk-size 5]
      (->> (-> plain lower-case (replace #"[^a-z0-9]" ""))
           (map encipher)
           (filter identity)
           (partition-all chunk-size)
           (map (partial reduce str))
           (join " "))))
