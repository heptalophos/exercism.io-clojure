(ns coordinate-transformation)

(defn translate2d 
  "Returns a function making use of a closure to
   perform a repeatable 2d translation of a coordinate pair."
  [dx dy]
  (fn [x y] [(+ x dx) (+ y dy)]))

(defn scale2d 
  "Returns a function making use of a closure to
   perform a repeatable 2d scale of a coordinate pair."
  [sx sy]
  (fn [x y] [(* x sx) (* y sy)]))

(defn compose-transform
  "Create a composition function that returns a function that 
   combines two functions to perform a repeatable transformation."
  [f g]
  (fn [x y] (let [[fx fy] (f x y)] (g fx fy))))

(defn memoize-transform
  "Returns a function that memoizes the last result.
   If the arguments are the same as the last call, 
   the memoized result is returned."
  [f]
  (let [lastx (atom ()) 
        lasty (atom ()) 
        lastf (atom ())]
    (fn [x y] (cond (and (= x @lastx) (= y @lasty))
                    (deref lastf)
                :else
                    (let [new-return (f x y)]
                      (swap! lastx (fn [_] x))
                      (swap! lasty (fn [_] y))
                      (reset! lastf new-return) 
                    new-return)))))
