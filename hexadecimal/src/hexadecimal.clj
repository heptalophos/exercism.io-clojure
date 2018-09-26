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

;;; -- or -- 
; (defn hex-to-int [hex]
;   (if (every? digits hex) (reduce #(+ (* % 16) %2) 0 (map digits (clojure.string/lower-case hex))) 0))