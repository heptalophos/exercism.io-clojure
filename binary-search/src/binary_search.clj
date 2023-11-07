(ns binary-search)

(defn middle
  [list]
  (int (bit-shift-right (count list) 1)))

(defn search-for 
  [item list]
  (let [mid (middle list)
        current (nth list mid)]
  (cond
      (= current item)
          mid
      (or (= mid (count list)) (zero? mid))
          (throw (Exception. (format "%s not found" item)))
      (< current item)
          (+ mid (search-for item (drop mid list)))
      (> current item)
          (search-for item (take mid list)))))