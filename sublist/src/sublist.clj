(ns sublist)

(defn- front-sublist?
    "Checking recursively equality of heads, returns true if 
     a list contains the other list at its front, false otherwise."
    [[x & xs] [y & ys]]
    (and (or (= x y) (nil? y))
         (or (nil? ys) (recur xs ys))))

(defn- sublist?
    "Returns true if first list is sublist of second, nil otherwise."
    [xs ys]
    (let [[p & ps] xs
          [q & qs] ys]
        (or (empty? xs)
            (and (=  p q) (front-sublist? qs ps))
            (and (seq qs) (recur xs qs)))))

(defn classify 
    "Determines the sublistness of first argument against the second."
    [xs ys]
    (cond
        (and (sublist? xs ys) (sublist? ys xs)) :equal
        (sublist? xs ys) :sublist
        (sublist? ys xs) :superlist
        :else :unequal))
