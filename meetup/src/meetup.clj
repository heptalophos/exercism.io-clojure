(ns meetup
    (:import [java.util GregorianCalendar]))

(def days {:sunday 1 :monday 2 :tuesday 3 :wednesday 4 
           :thursday 5 :friday 6 :saturday 7 })

(defn- week-start
    [month wk]
    (case wk
            :first 1
            :second 8
            :third 15
            :fourth 22
            :teenth 13
            :last (if (= 2 month) 23 25)))

(defn- day-of-week
    [year month week-start-on]
    (let [cal (GregorianCalendar/getInstance)]
         (.set cal GregorianCalendar/YEAR year)
         (.set cal GregorianCalendar/MONTH (dec month))
         (.set cal GregorianCalendar/DAY_OF_MONTH week-start-on)
         (.get cal GregorianCalendar/DAY_OF_WEEK))) 

(defn- days-offset
    [from to]
    (if (> from to) (+ (- 7 from) to) (- to from)))   

(defn- calculate-day
    [year month week-start-on day-in-week]
    (+ week-start-on 
       (days-offset (day-of-week year month week-start-on) day-in-week)))
    
(defn meetup 
    [month year day-in-week week] 
    (vector year
            month
            (calculate-day year month
                           (week-start month week)
                           (days day-in-week))))