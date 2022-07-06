(ns change)

(defn- change
       [value coins changed]
       (cond 
            (nil? (first coins)) 
                changed
            :else 
                (change (mod value (first coins)) 
                        (rest coins) 
                        (concat (repeat (quot value (first coins)) 
                                        (first coins)) 
                                changed))))

(defn issue
      [value coins]
      {:pre [(integer? value) (set? coins)]}
      (let [coins (into (sorted-set) (filter #(<= % value) coins))]
      (cond 
        (zero? value) 
            '()
        (or (empty? coins) (neg? value) (every? #(not= (/ value %) (quot value %)) coins)) 
            (throw (IllegalArgumentException. "cannot change"))
        :else 
            (->>    coins
                    (sort-by -)
                    (iterate rest)
                    (take-while first)
                    (map (fn [d] (change value d [])))
                    (sort-by count)
                    (first)
              ))))
