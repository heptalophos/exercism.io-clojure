(ns pascals-triangle)

(defn- subsequent 
       [present]
       (into [] (map + (cons 0 present) 
                       (conj present 0))))

(def triangle 
     (iterate subsequent [1N]))

(defn row 
      [n]
      (last (take n triangle)))
