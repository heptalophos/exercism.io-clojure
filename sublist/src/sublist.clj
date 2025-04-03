(ns sublist)

(defn- contains-head?
    "Checking recursively equality of heads, returns true if 
     a list contains another, smaller list at its front."
    [[x & xs] [y & ys]]
    (and (or (= x y) (nil? y))
         (or (nil? ys) (contains-head? xs ys))))

(defn- sublist?
    "Returns true if first list is sublist of second."
    [xs ys]
    (let [[p & ps] xs
          [q & qs] ys]
        (or (empty? xs)
            (and (=  p q) (contains-head? qs ps))
            (and (seq qs) (sublist? xs qs)))))

(defn classify 
    "Determine the sublistness of first argument against the second."
    [xs ys]
    (cond
        (and (sublist? xs ys) (sublist? ys xs)) :equal
        (sublist? xs ys) :sublist
        (sublist? ys xs) :superlist
        :else :unequal))
