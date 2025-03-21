(ns meetup
    ;;(:import (java.util.GregorianCalendar))
)

(def days-of-the-week {:monday 2 
                       :tuesday 3 
                       :wednesday 4 
                       :thursday 5 
                       :friday 6 
                       :saturday 7 
                       :sunday 1})

(defn start-of-week
  [month wk]
  (case wk
    :first 1
    :second 8
    :third 15
    :fourth 22
    :teenth 13
    :last (if (= 2 month) 23 25)))

(defn day-of-week
  [year month week-start]
  (let [cal (java.util.GregorianCalendar/getInstance)]
    (.set cal java.util.GregorianCalendar/YEAR year)
    (.set cal java.util.GregorianCalendar/MONTH (dec month))
    (.set cal java.util.GregorianCalendar/DAY_OF_MONTH week-start)
    (.get cal java.util.GregorianCalendar/DAY_OF_WEEK))) 

(defn days-offset
  "Calculates offset in days"
  [from to]
  (if (> from to)
    (+ (- 7 from) to)
    (- to from)))   

(defn calculate-day
  [year month week-start day-in-week]
  (+ week-start 
     (days-offset 
          (day-of-week year month week-start) day-in-week)))
    
(defn meetup 
  [month year day-in-week week] 
  (vector year
          month
          (calculate-day year
                         month
                         (start-of-week month week)
                         (days-of-the-week day-in-week))))