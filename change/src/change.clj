(ns change)

(defn- changerec
       [value coins change]
       (cond 
            (nil? (first coins)) change
            :else (changerec 
                    (mod value (first coins)) 
                    (rest coins) 
                    (concat (repeat 
                                (quot value (first coins)) 
                                (first coins)) 
                            change))))

(defn- change
       [value coins]
       (->> coins
            (sort-by -)
            (iterate rest)
            (take-while first)
            (map (fn [d] (changerec value d [])))
            (sort-by count)
            (first)))

(defn issue
      [value coins]
      {:pre [(integer? value) (set? coins)]}
      (let [coins (into (sorted-set) (filter #(<= % value) coins))]
      (cond 
        (zero? value) '()
        (or (empty? coins) 
            (neg? value) 
            (every? #(not= (/ value %) (quot value %)) coins)) 
                (throw (IllegalArgumentException. "cannot change"))
        :else (change value coins))))
