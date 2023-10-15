(ns squeaky-clean
  (:require [clojure.string :refer [split]]))

(defn- greek->nil
  [s]
  (apply str (filter (fn [x] (not (nil? x)))
                     (map #(if (and (<= 0x3B1 (int %))
                                    (<= (int %) 0x3C9)) 
                             nil 
                             %)
                          (seq s)))))
(defn- ctrl-char->ctrl-str
  [s]
  (apply str (filter (fn [x] (not (nil? x)))
                     (map #(if (Character/isISOControl %) 
                             "CTRL" 
                             %)
                          (seq s)))))
(defn- non-alpha->nil
  [s]
  (apply str (filter (fn [x] (not (nil? x)))
                     (map #(if (or (Character/isAlphabetic (int %))
                                   (= \_ %)) 
                             % 
                             nil)
                          (seq s)))))
(defn- space->underscore
  [s]
  (apply str (filter (fn [x] (not (nil? x)))
                     (map #(if (= % \space) 
                             \_ 
                             %)
                          (seq s)))))
(defn- kebab->camel
  [s]
  (let [[head & rest] (split s #"-")
        capitalize (fn [x] (str (Character/toUpperCase (first x)) 
                                (subs x 1)))]
    (str head (apply str (map #(capitalize %) rest)))))

(defn clean
  "Cleans input string `s` of non-alpha and lower greek-alphabet letters,
   converts space characters to underscores, ISOControl characters to a 
  \"CTRL\" string and translates the string from kebab-case to camel-case."
  [s]
  {:pre [(string? s)]}
  (->> s
       space->underscore 
       ctrl-char->ctrl-str
       kebab->camel
       non-alpha->nil 
       greek->nil))
