(ns dnd-character)

(defn- roll 
    "Rolls -once- a six-faced die"
    []
    (inc (rand-int 6)))

(defn score-modifier
    "Calculates a score's modifier"
    [score]
    (int (Math/floor (/ (- score 10) 2))))

(defn rand-ability
    "Generates a random ability"
    []
    (reduce + (rest (sort (repeatedly 4 roll)))))

(defn rand-character
    "Generates a random character"
    []
    (let [constitution (rand-ability)]
        {:strength  (rand-ability)
         :dexterity (rand-ability)
         :charisma  (rand-ability)
         :wisdom    (rand-ability)
         :intelligence (rand-ability)
         :constitution constitution
         :hitpoints (+ (score-modifier constitution) 10)}))
