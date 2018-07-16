(ns gigasecond
  (:require [clj-time.core :as time]))

(defn add-gigasecond
    [date]
    (time/plus date (time/seconds 1e9)))

(defn- format-output
    [date] 
    [(time/year date) (time/month date) (time/day date)])

(defn from 
    [year mon day]
    (-> (time/date-time year mon day)
        add-gigasecond
        format-output))