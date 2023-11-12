(ns clock)

(defn clock [hours minutes]
  (let [time (mod (+ (* hours 60) minutes) (* 60 24))
        hrs (mod (quot time 60) 24)
        min (mod time 60)]
  {:hour hrs :minute min}))

(defn clock->string [_clock]
  (format "%02d:%02d" (:hour _clock) (:minute _clock)))

(defn add-time [_clock time] 
  (clock (:hour _clock) (+ (:minute _clock) time)))