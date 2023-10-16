(ns robot-name)

(def used-names (atom ()))

(defn- generate-name
  "Generates a random robot name and checks if it exists. 
   If it does, `generate-name` calls itself again. 
   If it is a new name, it is first added to the existing 
   names and then the fcn returns the new name."
  []
  (let [letters (apply str (repeatedly 2 #(char (rand-nth (range 65 91)))))
        numbers (apply str (repeatedly 3 #(rand-int 10)))
        name (str letters numbers)]
    (cond (some (fn [x] (= x name)) (deref used-names))
          (generate-name)
          (swap! used-names conj name)
          name)))
    
(defrecord Robot [name])

(defn robot 
  "Creates a new Robot"
  [] 
  (->Robot (atom (generate-name))))

(defn robot-name
  "Accesses a robot's name"
  [robot]
  (deref (:name robot)))

(defn reset-name
  "Assigns a new name to an existing robot"
  [robot]
  (reset! (:name robot) (generate-name)))
