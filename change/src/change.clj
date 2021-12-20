(ns change)

(defn issue 
      [value coins]
      {:pre [(integer? value) (set? coins)]}
      (let  [coins (into (sorted-set) (filter #(<= % value) coins))]
      (cond (zero? value) '()
            (or (neg? value) 
                (empty? coins)) (throw (IllegalArgumentException. "cannot change"))
            :else
            (loop [change []
                   amount-left value]
                  (if-let [high-coin (first (filter #(<= % amount-left) 
                                            (sort > (vec coins))))]
                        (recur (conj change high-coin)
                               (- amount-left high-coin))
                  (sort < change))))))
