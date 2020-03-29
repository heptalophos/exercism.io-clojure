(ns robot-name)

(defn generate-name 
  []
  (let [ALPHABET (range 65 91)]
    (format "%1$s%2$s%3$03d" 
            (char (rand-nth ALPHABET)) 
            (char (rand-nth ALPHABET)) 
            (rand-int 1000))))

(defrecord Robot [name])

(defn robot 
  []
  (Robot. (atom (generate-name))))

(defn robot-name 
  [robot]
  @(:name robot))

(defn reset-name 
  [robot]
  (reset! (:name robot) (generate-name)))