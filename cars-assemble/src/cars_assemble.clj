(ns cars-assemble)

(def per-hour-baseline 221)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (let [success-rate 
          (condp >= speed 
                 0  0.0
                 4  1.0
                 8  0.9
                 9  0.8
                 10 0.77)
        true-speed 
          (* speed success-rate)]
  (* per-hour-baseline true-speed))
)

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (-> (production-rate speed)
      (/ 60)
      int)
)