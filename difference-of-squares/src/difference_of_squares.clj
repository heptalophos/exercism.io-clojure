(ns difference-of-squares)

(defn- naturals [n] 
  (->> (range)
       (map inc)
       (take n)))

(defn sum-of-squares [n]
  (reduce + (map #(* % %) (naturals n))))

(defn square-of-sums [n]
  (let [sum (reduce + (naturals n))]
    (* sum sum)))

(defn difference [n]
  (- (square-of-sums n) (sum-of-squares n)))




