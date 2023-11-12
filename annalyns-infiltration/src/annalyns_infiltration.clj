(ns annalyns-infiltration)

(defn can-fast-attack?
  "Returns true if a fast-attack can be made, false otherwise."
  [knight-awake?]
  (if knight-awake? false true))

(defn can-spy?
    "Returns true if the kidnappers can be spied upon, false otherwise."
    [knight-awake? archer-awake? prisoner-awake?]
    (cond
      knight-awake?
        true
      archer-awake?
        true
      :else 
        prisoner-awake?))

(defn can-signal-prisoner?
    "Returns true if the prisoner can be signalled, false otherwise."
    [archer-awake? prisoner-awake?]
    (let [archer-sleeping (not archer-awake?)]
        (if prisoner-awake? 
            archer-sleeping
            false)))

(defn can-free-prisoner?
    "Returns true if prisoner can be freed, false otherwise."
    [knight-awake? archer-awake? prisoner-awake? dog-present?]
    (let [archer-sleeping (not archer-awake?) 
          knight-sleeping (not knight-awake?)] 
        (and archer-sleeping 
            (or dog-present? 
                (and prisoner-awake? 
                     knight-sleeping)))))
