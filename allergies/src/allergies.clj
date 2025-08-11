(ns allergies )

(def ^:private ^:const causes
  [:eggs :peanuts :shellfish :strawberries :tomatoes :chocolate :pollen :cats])

(def ^:private ^:const allergens 
  (zipmap causes (map (fn [_] (bit-shift-left 1 _)) (range (count causes)))))

(defn allergies 
  [score]
  (vec (for [[allergen code] allergens :when (> (bit-and score code) 0)]
            allergen)))

(defn allergic-to? 
  [score allergen]
  (boolean (some (fn [_] (= _ allergen)) (allergies score))))
