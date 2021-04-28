(ns hexadecimal)

(def digits (zipmap "0123456789abcdef" (range)))

(def powers (iterate #(* % 16) 1))

(defn hex-to-int [hex]
  (if (every? digits hex) 
      (->> hex
           (map digits)
           reverse
           (map * powers)
           (reduce +))
      0))

