(ns bird-watcher)

(def last-week '[0 2 5 3 7 8 4])

(defn today 
      [birds] 
    (last birds))

(defn inc-bird 
      [birds]
    (#(assoc % 
        (- (count %) 1) 
        (+ (today %) 1)) 
     birds))

(defn day-without-birds? 
      [birds]
    (->> birds 
         (not-every? #(> % 0))))

(defn n-days-count 
      [birds n]
    (->> birds
         (take n)
         (reduce +)))

(defn busy-days 
      [birds]
    (->> birds
         (filter #(>= % 5))
         count))

(defn odd-week? 
      [birds]
    (= birds 
       (take (count birds) 
             (cycle [1 0]))))
