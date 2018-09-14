(ns strain)

(defn retain [pred xs]
      (for [x xs :when (pred x)] x))

(defn discard [pred xs]
      (retain #(not (pred %)) xs))
