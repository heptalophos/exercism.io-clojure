(ns octal)

(defn to-decimal 
    [oct-str] 
    (if (re-matches #"[0-7]+" oct-str)
      (apply + 
        (map-indexed (fn [idx digit] (bit-shift-left (Character/getNumericValue digit) (* 3 idx))) (reverse oct-str)))
       0))
