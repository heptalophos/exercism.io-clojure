(ns gigasecond
(:import [java.time Duration LocalDateTime])
)

(def ^:private gigasec (Duration/ofSeconds 1e9))

(defn- add-gigasecond
    [date]
    (.plus date gigasec)
)

(defn- from-date
    [y m d] 
    (LocalDateTime/of y m d 0 0)
)

(defn- format-output
    [date] 
    (vector (.getYear date) 
            (.getMonthValue date) 
            (.getDayOfMonth date)
    )
)

(defn from 
    [year mon day]
    (-> (from-date year mon day)
        add-gigasecond
        format-output)
)