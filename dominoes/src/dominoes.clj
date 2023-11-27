(ns dominoes)

(defn- remaining 
    [stone ds]
    (for [i (range (count ds))
         :let [[s [[a b] & rest]] (split-at i ds)
               more (cond (= a stone) b (= b stone) a :else nil)]
         :when more]
         [more (concat s rest)]))

(defn- boundary 
    [stone ds]
    (some (fn [[stone ds]]
            (if (not (seq ds))
                stone
                (boundary stone ds))) 
            (remaining stone ds)))

(defn can-chain? 
    [[[a-stone b-stone] & dominoes]] 
    (cond 
        (nil? a-stone)  
            true
        (nil? dominoes) 
            (= a-stone b-stone)
        :else     
            (= a-stone (boundary b-stone (vec dominoes)))))