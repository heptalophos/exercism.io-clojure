(ns kindergarten-garden
  (:require [clojure.string :refer [lower-case]]))

(def kids ["Bob" "Alice" "David" "Kincaid"
           "Charlie" "Larry" "Ileana" "Ginny"
           "Joseph" "Harriet" "Fred" "Eve"])

(defn- plants 
    [diagram]
    (map {\C :clover \G :grass \R :radishes \V :violets} 
         diagram))

(defn garden 
    ([diagram]
        (garden diagram kids))
    ([diagram students]
        (->> diagram
             (re-seq #"[CGRV]+")
             (map (fn [_] (partition 2 _)))
             (apply map vector)
             (map (fn [_] (reduce concat _)))
             (map plants)
             (zipmap (map (fn [_] (keyword (lower-case _))) 
                          (sort students))))))
