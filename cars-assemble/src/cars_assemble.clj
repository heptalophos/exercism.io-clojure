(ns cars-assemble)

(def per-hour-baseline 221)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (let [success-rate (cond 
                        (=  0 speed)    0.0
                        (<= 1 speed 4)  1.0
                        (<= 5 speed 8)  0.9
                        (=  9 speed)    0.8
                        (= 10 speed)    0.77)]
   (* speed per-hour-baseline success-rate ))
)

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (-> (production-rate speed)
      (/ 60)
      int)
)