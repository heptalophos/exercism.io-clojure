(ns bob
  (:require [clojure.string :as string]))

(defn question? [in]
  (= (last in) \?))

(defn silent? [in]
  (empty? (string/trim in)))

(defn yell? [in]
  (let [clean-in (apply str (re-seq #"[a-zA-Z]" in))]
    (and (not-empty clean-in) (re-matches #"\p{Upper}+" clean-in))))

(defn response-for [in]
  (cond
    (silent? in) "Fine. Be that way!"
    (yell? in) "Whoa, chill out!"
    (question? in) "Sure."
    :default "Whatever."))
