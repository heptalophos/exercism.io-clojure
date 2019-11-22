(ns sum-of-multiples)


(defn sum-of-multiples [multiples limit] 
    (->> multiples
         (mapcat #(range 0 limit %))
         set 
         (reduce +)))
