(ns all-your-base)

(defn- digs->dec 
  [digits base]
  (loop [n 0 d digits]
      (if (not (seq d))
          n
          (recur (+ (first d) (* base n)) (rest d)))))

(defn- dec->digs 
  [num base]
  (loop [ds [] current num]
      (if (zero? current)
         (if (not (seq ds)) '(0) ds)
         (recur (cons (mod current base) ds)
                (quot current base)))))

(defn convert
  [inbase digits outbase]
  (if (or (< inbase 2)
          (< outbase 2)
          (seq (filter neg? digits))
          (seq (filter (fn [_] (>= _ inbase)) 
                       digits)))
      nil
      (if (not (seq digits))
          '()
          (dec->digs (digs->dec digits inbase) outbase))))
