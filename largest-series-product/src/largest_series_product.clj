(ns largest-series-product)

(defn largest-product 
  [size digits]
  (cond
      (zero? size) 
        1 
      (> size (count digits)) 
        (throw (Exception. "span should be less than length of digits"))
      :else 
        (apply max (map (partial apply *) 
        (partition size 1 
          (map (fn [x] 
                  {:pre [(Character/isDigit x)]} 
                  (Character/digit x 10)) 
                  digits))))))
