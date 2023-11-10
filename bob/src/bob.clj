(ns bob
  (:require [clojure.string :refer [trim]]))

(defn- question? [in]
  (= (last (trim in)) \?))

(defn- silent? [in]
  (empty? (trim in)))

(defn- yell? [in]
  (let [clean-in (apply str (re-seq #"[a-zA-Z]" in))]
  (and (not-empty clean-in) 
       (re-matches #"\p{Upper}+" clean-in))))

(defn response-for [in]
  (cond
      (and (yell? in) (question? in)) 
          "Calm down, I know what I'm doing!"
      (silent? in) 
          "Fine. Be that way!"
      (yell? in) 
          "Whoa, chill out!"
      (question? in) 
          "Sure."
   :else 
          "Whatever."))