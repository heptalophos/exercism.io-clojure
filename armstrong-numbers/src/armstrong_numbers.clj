(ns armstrong-numbers)

(defn- ** 
    "Returns the (integer) nth-power of x"
    [x n] 
    (->> x
         (bigint)
         (repeat n)
         (reduce *)))

(defn armstrong?
    "Checks if num is an armstrong (or narcissistic) number"
    [num]
    (->> num
         (str)
         (seq)
         (map #(Character/digit % 10))
         (map #(** % (count (str num))))
         (reduce +)
         (= num)))