(ns complex-numbers)

(defn real 
  [[a b]]
  a)

(defn imaginary 
  [[a b]]
  b)

(defn abs 
  [[a b]]
  (Math/sqrt (apply + (map #(Math/pow % 2) [a b]))))

(defn conjugate 
  [[a b]]
  [a (* b -1)])

(defn add 
  [[a b] [c d]]
  [(+ a c) (+ b d)] )

(defn sub [[a b] [c d]] 
  [(- a c) (- b d)] )

(defn mul 
  [[a b] [c d]] 
  [(- (* a c) (* b d))
  (+ (* a d) (* b c))])

(defn- denom 
  [c n]
  (let [absc (abs c)]
    (/ n (* absc absc))))

(defn div [[a b] [c d]] 
  (->> (conjugate [c d])
       (mul [a b])
       (map (partial denom [c d]))
       (apply vector)))