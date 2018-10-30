(ns allergies)


(def allergens 
  (zipmap [:eggs :peanuts :shellfish :strawberries :tomatoes :chocolate :pollen :cats] (range)))


(defn allergies [code]
  (vec (for [[score allergen] allergens :when (pos? (bit-and code allergen))] score)))


(defn allergic-to? [code allergen] 
  (-> allergen
      allergens
      (bit-and code)
      pos?))
