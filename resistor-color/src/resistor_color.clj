(ns resistor-color)

(def colors ^:private
    ["black" "brown" "red" "orange" "yellow" 
     "green" "blue" "violet" "grey" "white"])

(defn color-code
    "Returns the numerical value associated with the given color"
    [color]
    (let [color=>idx (zipmap colors (range))]
    (color=>idx color)))
