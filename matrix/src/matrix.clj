(ns matrix
    (:require [clojure.string :refer [split-lines]]))

(defn- rows
    "Returns a matrix, after splitting the lines 
     of a string s and mapping them into row vectors"
    [s]
    (->> s 
         split-lines
         (mapv #(read-string (str "[" % "]")))))

(defn get-row
    "Returns the i-th row of the matrix m"
    [m i]
    (-> m 
        rows
        (nth (dec i) "row not found")))

(defn get-column
    "Returns the i-th column of the matrix m"
    [m i]
    (letfn [(transpose [rs] (apply map vector rs))]
    (-> m
        rows
        transpose
        (nth (dec i) "column not found"))))
