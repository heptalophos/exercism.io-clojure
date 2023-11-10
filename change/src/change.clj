(ns change)

(defn- change
    [value coins changed]
    (cond
        (nil? (first coins))
           changed
      :else
        (change (mod value (first coins)) (rest coins)
                (concat (repeat (quot value (first coins)) (first coins))
                        changed))))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn issue
    [value coins]
    {:pre [(integer? value) (set? coins)]}
    (let [coins (into (sorted-set) (filter (fn [_ ] (<= _ value)) coins))] 
    (cond
        (zero? value)
            '()
        (or (not (seq coins)) (neg? value)
            (every? (fn [_] (not= (/ value _) (quot value _))) coins))
            (throw (IllegalArgumentException. "cannot change"))
      :else
        (->>  coins
              (sort-by -)
              (iterate rest)
              (take-while first)
              (map (fn [_] (change value _ [])))
              (sort-by count)
              (first)))))
