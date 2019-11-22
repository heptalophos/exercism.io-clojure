(ns binary-search)

(defn middle
  [lst]
  (int (/ (count lst) 2)))

(defn search-for 
  [item lst]
  (let [mid (middle lst)
        curr (nth lst mid)]
  (cond 
    (= curr item) mid
    (or 
      (= mid (count lst)) (zero? mid)) 
        (throw (Exception. (format "%s not found" item)))
      (< curr item) 
        (+ mid (search-for item (drop mid lst)))
      (> curr item) 
        (search-for item (take mid lst)))))