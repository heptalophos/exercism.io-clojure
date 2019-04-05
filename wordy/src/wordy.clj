(ns wordy)

;;- Tokenize symbols either as operators, or integer operands
(defn- tokenize [word]
  (or ({"plus" + "minus" - "multiplied" * "divided" /} word)
      (Integer/parseInt word)))

;;-  A simple function that converts a simple infix expression to a simple prefix expression and 
;;-  a complex infix expression to a series of recursive evaluations (evaluate the first 3 tokens, 
;;-  plug the result as head token to the rest of the expression, recursively evaluate the first 
;;-  3 tokens again, et.c.
; (defn- calculate-infix
;   ([x op y] (op x y))
;   ([x op y & expr]
;    (apply calculate-infix (cons (calculate-infix x op y) expr))))

;;- An alternative strategy, would be to treat an expression as a list of tokens, for example: 
;;- '(a + b - c * d / e), partition its tail into a list of 2 item lists (<operation> <operand>)
;;- like: (partition 2 (rest '(a + b - c * d / e))) => ((+ b) (- c) (* d) (/ e)) and then use 
;;- reduce to evaluate the list.
(defn- calculate [x & expr]
  (reduce (fn [acc [op y]] (op acc y)) x (partition 2 expr)))

;;- Using thread-last, parse string to a list of symbols, remove symbols that will not be tokens of the 
;;- infix expression, tokenize the remaining symbols and apply the infix-calculator to obtain the result 
(defn evaluate [input]
  (->> (re-seq #"(?:\w+)|(?:-?\d+)" input)
       (remove #{"What" "is" "by" "to" "the" "power"})
       (map tokenize)
       (apply calculate)))