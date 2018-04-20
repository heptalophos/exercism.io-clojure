(ns armstrong-numbers  
  (:import [java.Math]))

(defn get-number-of-digits
    "number of digits of n if n is an integer and greater or equal to 0"
    [n]
    {:pre [(not (nil? n)) (integer? n)]}
    (if (zero? n)
        1
        (if (pos? n )
            (inc (int (Math/log10 n )))
            nil)))

(defn get-digits
    "the digits of given int n"
    [n]
    {:pre [(some? n) (integer? n)]}
    (when-not (zero? n)
        (lazy-seq (cons (rem n 10) (get-digits (quot n 10))))))



(defn armstrong? 
  "Compute if n is an Armstrong number : 
    if it is the sum of its own digits each raised to the power of the number of digits"
  [n]
  {:pre [(some? n) (integer? n)]}
  (if (zero? n)
    false
    (if (pos? n)
      (= n (reduce + (map #(int (Math/pow % (get-number-of-digits n))) (get-digits n))))
      false)))

; (defn generate-armstrong-numbers
;   "generate armstrong numbers for ranges of ints greater than 0 defined by from and to"
;   [^Integer from, ^Integer to]
;   {:pre [(some? from) (integer? from) (some? to) (integer? to) ]}
;   (if (< from to)
;     (into [] (for [x (range from to)
;                    :when (true? (armstrong? x))]
;                x))
;      []))

; (defn -main
;   []
;   (println (str "armstrong numbers between 100 and 1000: " (generate-armstrong-numbers 100 1000)))  )
