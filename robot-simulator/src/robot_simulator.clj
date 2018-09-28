(ns robot-simulator)

(defn robot [position bearing]
  {:bearing bearing
   :coordinates position})

(defn turn-right [bearing]
  (case bearing
    :north :east
    :east :south
    :south :west
    :west :north))

(defn turn-left [bearing]
  (case bearing
    :north :west
    :east :north
    :south :east
    :west :south))

(defn- instruct [robot instruction]
  (case instruction
    \L (update robot :bearing turn-left)
    \R (update robot :bearing turn-right)
    \A (case (:bearing robot)
         :north (update-in robot [:coordinates :y] inc)
         :east  (update-in robot [:coordinates :x] inc)
         :south (update-in robot [:coordinates :y] dec)
         :west  (update-in robot [:coordinates :x] dec))
    :else nil))

(defn simulate [commands robot]
    (reduce instruct robot commands))


