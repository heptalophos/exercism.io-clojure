(ns eliuds-eggs)

(defn egg-count
    "Returns the number of 1 bits in the 
     binary representation of the given number."
    [number]
    (cond
        (< number 1) 0
        :else (+ (bit-and number 1)
                 (egg-count (bit-shift-right number 1)))))