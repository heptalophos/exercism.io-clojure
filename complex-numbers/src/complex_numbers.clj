(ns complex-numbers
  (:refer-clojure :exclude [abs]))

(defn real [[r _]] r)

(defn imaginary [[_ i]] i)

(defn abs
  [[r i]]
  (->> [r i]
       (map (fn [_] (Math/pow _ 2)))
       (apply +)
       (Math/sqrt)
       (float)))

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
  [(- (* r1 r2) (* i1 i2)) (+ (* r1 i2) (* i1 r2))])

(defn- denom 
  [c n]
  (let [absc (abs c)]
  (/ n (* absc absc))))

(defn div [[r1 i1] [r2 i2]] 
  (->> (conjugate [r2 i2])
       (mul [r1 i1])
       (map (partial denom [r2 i2]))
       (reduce vector)))
