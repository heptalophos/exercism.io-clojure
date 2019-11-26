(ns clock)

(defn clock->string [clock] 
  (format "%02d:%02d" (:hour clock) (:minute clock)))

(defn clock [hours minutes]
  (let [time (mod (+ (* hours 60) minutes) 
                  (* 60 24))
        hrs (mod (quot time 60) 24)
        min (mod time 60)]
  {:hour hrs :minute min}))

(defn add-time [clck time] 
  (clock (:hour clck) 
         (+ (:minute clck) time)))