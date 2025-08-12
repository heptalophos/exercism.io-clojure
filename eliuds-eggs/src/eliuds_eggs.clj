(ns eliuds-eggs)

(defn egg-count
    "Returns the number of 1 bits in the 
     binary representation of the given number."
    [number]
    (cond
        (< number 1) 0
        :else (+ (bit-and number 1)
                 (egg-count (bit-shift-right number 1)))))
    ;; (->> number
    ;;      (iterate #(bit-shift-right % 1))
    ;;      (take-while #(> % 0))
    ;;      (map #(bit-and 1 %))
    ;;      (apply +)))