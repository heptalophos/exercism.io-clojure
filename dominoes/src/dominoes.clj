(ns dominoes)

(defn- remaining 
    [d ds]
    (for [i (range (count ds))
         :let [[s [[a b] & r]] (split-at i ds)
               m (cond (= a d) b (= b d) a)]
         :when m]
         [m (concat s r)]))

(defn- boundary 
    [d ds]
    (some (fn [[d ds]]
            (if (not (seq ds)) 
               d 
               (boundary d ds))) 
          (remaining d ds)))

(defn can-chain? 
    [[[a b] & ds]] 
    (cond 
        (nil? a)  
            true
        (nil? ds) 
            (= a b)
        :else     
            (= a (boundary b (vec ds)))))