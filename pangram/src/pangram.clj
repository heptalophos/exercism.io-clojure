(ns pangram)

(defn pangram? [word]
  (->> word
       clojure.string/lower-case
      (filter #(and (<= (int \a) (int %)) 
                    (>= (int \z) (int %))))
       distinct
       count
       (= 26)))
