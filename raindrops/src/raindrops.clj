(ns raindrops)

(defn- divided-by [num denom]
  (zero? (mod num denom)))

(defn convert [num]
  (cond-> nil
    (divided-by num 3) (str "Pling")
    (divided-by num 5) (str "Plang")
    (divided-by num 7) (str "Plong")
    :else (or (str num))))
