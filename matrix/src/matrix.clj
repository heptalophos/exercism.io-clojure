(ns matrix
    (:require [clojure.string 
               :refer [split-lines]]))

(defn- into-matrix
    "Returns a matrix of the individual words of s, after 
     splitting it into a list of vectors, one for each line"
    [s]
    (->> s
         (split-lines)
         (map #(read-string (str "[" % "]")))))

(defn get-row
    "Returns the i-th row of the matrix s"
    [s i]
    (-> s
        into-matrix
        (nth (dec i))))

(defn get-column
    "Returns the i-th column of the matrix s"
    [s i]
    (letfn [(transpose [rs] (apply map list rs))]
    (-> s
        into-matrix
        transpose
        (nth (dec i)))))
