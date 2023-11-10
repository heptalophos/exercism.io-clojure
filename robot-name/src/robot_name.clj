(ns robot-name)

(def ^:private capital-alphas (map (fn [_] (char _)) (range 65 91)))
(def ^:private digits (map (fn [_] (char _)) (range 48 58)))

(def used-names (atom ()))

(defn- generate-name
  "Generates a random robot name and checks if it exists. 
   If it does, `generate-name` calls itself again. 
   If it is a new name, it is first added to the existing 
   names and then the fcn returns the new name."
  []
  (let [letters (apply str (repeatedly 2 #(rand-nth capital-alphas)))
        numbers (apply str (repeatedly 3 #(rand-nth digits)))
        name (str letters numbers)]
    (cond (some (fn [_] (= _ name)) (deref used-names))
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
