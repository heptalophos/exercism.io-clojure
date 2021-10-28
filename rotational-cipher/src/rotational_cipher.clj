(ns rotational-cipher)


(defn rotate
    "Shifts a string's alphabetic characters' values ofsetting them
     by an integer key"
    [text key] 
    (letfn [(rot26 
             [ch]
             (cond
                (Character/isLetter ch) 
                ;; only rotate alpha characters
                    (let [base 
                          (cond 
                              (Character/isUpperCase ch) (int \A) 
                              :else (int \a))]
                    (char (+ base (mod (+ (- (int ch) base) key) 26))))
                :else 
                    ch))]
    (->> text
         char-array
         (map #(rot26 %))
         (apply str)))) 
