;
(ns say
    (:require [clojure.pprint :refer [cl-format]]
              [clojure.string :refer [replace]]))

(defn number [input]
  (if
    (or (< input 0) (> input 999999999999))
    (throw (IllegalArgumentException. "Out of range"))
    (replace (cl-format nil "~R" input) #"," "")))