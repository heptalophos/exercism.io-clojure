(ns binary-search-tree)

(defn value [node]
  (:value node ))

(defn left [node]
  (:left node))

(defn right [node]
  (:right node))

(defn singleton [value] 
  {:value value nil nil} )

(defn insert [val node]
  (cond (nil? node) (singleton val)
        (<= val (value node)) (assoc node :left (insert val (left node)))
        (> val (value node)) (assoc node :right (insert val (right node)))
        :else node ))

(defn to-list [tree]
  (if (nil? tree)
    []
    (concat 
     (to-list (left tree)) [(value tree)] (to-list (right tree)) ) ))

(defn from-list [values] 
  (reduce (fn [acc val] (insert val acc)) nil values))
