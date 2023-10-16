(ns squeaky-clean (:require [clojure.string :refer [split]]))

(defn- greek->nil [s]
  (apply str (filter (fn [x] (not (nil? x)))
                     (map #(cond (and (<= 0x3B1 (int %)) (<= (int %) 0x3C9)) 
                              nil :else %)
                      (seq s)))))

(defn- non-alpha->nil [s]
  (apply str (filter (fn [x] (not (nil? x)))
                     (map #(cond (or (Character/isAlphabetic (int %)) (= \_ %))
                              %  :else nil)
                      (seq s)))))

(defn- ctrl-char->ctrl-str [s]
  (apply str (map #(cond (Character/isISOControl %) "CTRL" :else %) (seq s))))

(defn- space->underscore [s]
  (apply str (map #(cond (Character/isWhitespace %) \_ :else %) (seq s))))

(defn- kebab->camel [s]
  (let [[head & rest] (split s #"-")
        capitalize (fn [x] (str (Character/toUpperCase (first x)) (subs x 1)))]
  (str head (apply str (map #(capitalize %) rest)))))

(defn clean
  "Cleans input string `s` of non-alpha and lower greek-alpha characters.
   Converts space characters to underscores. 
   Converts any ISOControl character to a \"CTRL\" string. 
   Translates the string from kebab-case to CamelCase."
  [s]
  {:pre [(string? s)]}
  (non-alpha->nil 
   (greek->nil 
    (space->underscore 
     (ctrl-char->ctrl-str 
      (kebab->camel s))))))
