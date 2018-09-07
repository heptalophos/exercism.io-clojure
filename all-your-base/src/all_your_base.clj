(ns all-your-base)

(defn- digs->dec [digits base]
    (loop [n 0 dig digits]
      (if (empty? digits) n (recur (+ (first dig) (* base n)) (rest dig)))))

(defn- dec->digs [num base]
    (loop [digits [] cur num]
        (if (zero? cur) 
            (if (empty? digits ) '(0) digits)
            (recur (cons (mod cur base) digits)
                   (quot cur base)))))

(defn convert [inbase num outbase] 
	(if (or (< inbase 2) 
			(< outbase 2) 
			(not (empty? (filter neg? num)))
			(not (empty? (filter #(>= % inbase) num)))) 
		nil
		(if (empty? num) 
			'()
			(dec->digs (digs->dec num inbase) outbase))))
