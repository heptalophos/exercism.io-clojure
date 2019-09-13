(ns change)

; (defn issue [] 
;       )

(defn- possible-changes [changes value coins]
  (map
    (fn [coin]
      (when-let [prev (nth changes (- value coin) nil)]
        (cons coin prev)))
    coins))

(defn- change-step [coins changes value]
  (let [candidates (remove nil? (possible-changes changes value coins))
        change (when (seq candidates)
                 (apply min-key count candidates))]
    (conj changes change)))

(defn issue [value coins]
  (let [changes (reduce
                  (partial change-step coins)
                  ['()]
                  (range 1 (inc value)))
        change (peek changes) ]
    (cond
      (neg? value) (throw (IllegalArgumentException. "cannot change"))
      (nil? change) (throw (IllegalArgumentException. "cannot change"))
      :else (sort change))))