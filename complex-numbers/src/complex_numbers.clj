(ns complex-numbers
  (:require [clojure.math.numeric-tower :refer [expt sqrt]])
  ;; (:require [clojure.math :refer [ sqrt]])
  (:refer-clojure :exclude [abs]))

(defn real 
  [[r _]]
  r)

(defn imaginary 
  [[_ i]]
  i)

(defn abs 
  [[r i]]
  (float (sqrt (apply + (map #(expt % 2) [r i])))))

(defn conjugate 
  [[r i]]
  [r (* i -1)])

(defn add 
  [[r1 i1] [r2 i2]]
  [(+ r1 r2) (+ i1 i2)] )

(defn sub [[r1 i1] [r2 i2]] 
  [(- r1 r2) (- i1 i2)] )

(defn mul 
  [[r1 i1] [r2 i2]] 
  [(- (* r1 r2) (* i1 i2))
  (+ (* r1 i2) (* i1 r2))])

(defn- denom 
  [c n]
  (let [absc (abs c)]
    (/ n (* absc absc))))

(defn div [[r1 i1] [r2 i2]] 
    (->> (conjugate [r2 i2])
         (mul [r1 i1])
         (map (partial denom [r2 i2]))
         (apply vector)))
