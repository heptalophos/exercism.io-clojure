(ns leap)

(defn- divides?
  [divisor n]
  (if (== 0 (mod n divisor)) 
      true 
      false))

(defn leap-year? 
  [year] 
  (if (divides? 100 year)
      (divides? 400 year)
      (divides? 4 year)))