(ns all-your-base)

(defn- digs->dec 
  [digits base]
  (loop [n 0 d digits]
     (if (not (seq d))
        n
        (recur (+ (first d) (* base n)) (rest d)))))

(defn- dec->digs 
  [num base]
  (loop [ds [] cur num]
     (if (zero? cur)
         (if (not (seq ds)) '(0) ds)
         (recur (cons (mod cur base) ds) (quot cur base)))))

(defn convert
  [inbase digits outbase]
  (if (or (< inbase 2)
          (< outbase 2)
          (seq (filter neg? digits))
          (seq (filter #(>= % inbase) digits))) 
	   nil
     (if (not (seq digits))
        '()
        (dec->digs (digs->dec digits inbase) outbase))))
