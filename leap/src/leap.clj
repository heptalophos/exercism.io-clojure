(ns leap)

(defn- divides?
  [divisor n]
  (if (== 0 (mod n divisor)) true false))

(defn leap-year? 
  [year] 
  (if
    (or 
      (divides? 400 year) 
      (and 
        (divides? 4 year) 
        (not (divides? 100 year)))) 
    true 
    false))
