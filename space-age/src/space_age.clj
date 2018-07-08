(ns space-age)

(def earth-period 31557600)

(defn age [seconds planet-factor]
  (-> (/ seconds earth-period)
      (/ planet-factor)))

(defn on-mercury 
  [seconds] 
  (age seconds 0.2408467))

(defn on-venus 
  [seconds] 
  (age seconds 0.61519726))

(defn on-earth 
  [seconds] 
  (age seconds 1))

(defn on-mars 
  [seconds] 
  (age seconds 1.8808158 ))

(defn on-jupiter 
  [seconds] 
  (age seconds 11.862615 ))

(defn on-saturn 
  [seconds] 
  (age seconds 29.447498 ))

(defn on-uranus [seconds]
  (age seconds 84.016846))

(defn on-neptune 
  [seconds] 
  (age seconds 164.79132 ))