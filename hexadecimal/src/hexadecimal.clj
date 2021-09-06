(ns hexadecimal)

(def digits (zipmap "0123456789abcdef" (range)))

(def powers (iterate #(* % 16) 1))

(defn hex-to-int 
     [hex]
     "Converts a hexadecimal string to a decimal integer
      by checking hexadecimal well-formedness, 
         mapping hex digits to decimal values, 
         reversing their order, 
         raising them to powers of 16 and 
         adding them up."
     (if (every? digits hex) 
          (->> hex
               (map digits)
               reverse
               (map * powers)
               (reduce +))
          0))

