(ns bird-watcher)

(def last-week '[0 2 5 3 7 8 4])

(defn today 
      [birds] 
    (last birds))

(defn inc-bird 
      [birds]
    (-> birds 
        pop
        (conj (-> birds 
                  today 
                  inc))))

(defn day-without-birds? 
      [birds]
    (not-every? #(> % 0) birds))

(defn n-days-count 
      [birds n]
    (->> birds
         (take n)
         (reduce +)))

(defn busy-days 
      [birds]
    (count (filter #(>= % 5) birds)))

(defn odd-week? 
      [birds]
    (= birds (take (count birds) (cycle [1 0]))))
