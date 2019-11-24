(ns space-age)

(def earth-period 31557600)

(defn planet-year [seconds orbital-period]
  (-> (/ seconds earth-period)
      (/ orbital-period)))

(defn on-mercury 
  [seconds] 
  (planet-year seconds 0.2408467))

(defn on-venus 
  [seconds] 
  (planet-year seconds 0.61519726))

(defn on-earth 
  [seconds] 
  (planet-year seconds 1))

(defn on-mars 
  [seconds] 
  (planet-year seconds 1.8808158 ))

(defn on-jupiter 
  [seconds] 
  (planet-year seconds 11.862615 ))

(defn on-saturn 
  [seconds] 
  (planet-year seconds 29.447498 ))

(defn on-uranus [seconds]
  (planet-year seconds 84.016846))

(defn on-neptune 
  [seconds] 
  (planet-year seconds 164.79132 ))