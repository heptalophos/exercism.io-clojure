(ns wordy)

(defn- tokenize [word]
  (or ({"plus" + "minus" - "multiplied" * "divided" /} word)
      (Integer/parseInt word)))

(defn- calculate-infix
  ([x op y] (op x y))
  ([x op y & xs]
   (apply calculate-infix (cons (calculate-infix x op y) xs))))

(defn evaluate [input]
  (->> (re-seq #"(?:\w+)|(?:-?\d+)" input)
       (remove #{"What" "is" "by" "to" "the" "power"})
       (map tokenize)
       (apply calculate-infix)))