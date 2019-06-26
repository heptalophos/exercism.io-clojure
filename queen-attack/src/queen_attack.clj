(ns queen-attack)


(def empty-board (vec (repeat 8 (vec (repeat 8 "_")))))


(defn- set-queen 
    [board square queen]
    (if square
        (assoc-in board square queen)
        board))


(defn board-string 
    [{:keys [w b]}] 
    (-> empty-board
        (set-queen w "W")
        (set-queen b "B")
        (->> (map (partial interpose " ")))
        (interleave (repeat "\n"))
        (->> (apply concat) (apply str))))


(defn can-attack 
    [board]
    (let [{[xw yw] :w [xb yb] :b} board
         dx (Math/abs (- xw xb))
         dy (Math/abs (- yw yb))]
    (and (and :w :b) 
         (or (= 0 dx)
             (= 0 dy)
             (= 1 (/ dx dy))))))
 