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
    ([diagram] (garden diagram kids))
    ([diagram students]
        (->> diagram
             (re-seq #"[CGRV]+")
             (map #(partition 2 %))
             (apply map vector)
             (map #(apply concat %))
             (map plants)
             (zipmap (map #(keyword (lower-case %)) 
                          (sort students)))
        )
    )
)
