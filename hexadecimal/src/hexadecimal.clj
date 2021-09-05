(ns hexadecimal)

(def digits (zipmap "0123456789abcdef" (range)))

(def powers (iterate #(* % 16) 1))

(defn hex-to-int 
     [hex]
     "Converts a hexadecimal string to a decimal integer
      by: 1. checking hexadecimal well-formedness, 
          2. mapping hex digits to decimal values, 
          3. reversing their order, 
          4. raising them to powers of 16 and 
          5. adding them up."
     (if (every? digits hex) 
          (->> hex
               (map digits)
               reverse
               (map * powers)
               (reduce +))
          0))

