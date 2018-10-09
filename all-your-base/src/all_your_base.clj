(ns all-your-base)

(defn- digs->dec [digits base]
    (loop [n 0 d digits]
      (if (empty? d) 
     	  n 
		  (recur (+ (first d) (* base n)) (rest d)))))

(defn- dec->digs [num base]
    (loop [ds [] cur num]
        (if (zero? cur) 
            (if (empty? ds ) '(0) ds)
            (recur (cons (mod cur base) ds)
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
