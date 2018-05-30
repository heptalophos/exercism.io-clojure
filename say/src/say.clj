;
(ns say
    (:require [clojure.pprint :as prpr]
              [clojure.string :as str]))

(defn number [input]
  (if
    (or (< input 0) (> input 999999999999))
    (throw (IllegalArgumentException. "Out of range"))
    (str/replace (prpr/cl-format nil "~R" input) #"," "")))
