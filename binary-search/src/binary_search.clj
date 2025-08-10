(ns binary-search)

(defn- middle
    "Calculate the middle index of a range 
     from low to high (inclusive)."
    [low high]
    (+ low (bit-shift-right (- high low) 1)))

(defn search-for
    "Perform binary search to find needle 
     in sorted vector haystaq.
     Returns the index of needle if found, -1 if not."
    ([needle haystaq]
    (if (zero? (count haystaq))
        -1
        (search-for needle haystaq 0 (dec (count haystaq)))))
    ([needle haystaq low high]
    (if (> low high)
        -1
        (let [midx (middle low high)
              mid (nth haystaq midx)]
        (cond
            (= mid needle) midx
            (> mid needle) 
                (search-for needle haystaq low (dec midx))
            (< mid needle) 
                (search-for needle haystaq (inc midx) high))))))