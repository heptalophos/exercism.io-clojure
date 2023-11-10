(ns allergies )

(def ^:private allergens {:eggs 1 :peanuts 2 :shellfish 4 :strawberries 8
                          :tomatoes 16 :chocolate 32 :pollen 64 :cats 128})

(defn allergies [code]
  (vec (for [[score allergen] allergens 
        :when (pos? (bit-and code allergen))] score)))

(defn allergic-to? [code allergen] 
  (-> allergen
      allergens
      (bit-and code)
      pos?))
