(ns grade-school)

(defn grade 
    [school grade]  
    (get school grade []))

(defn add 
    [school name in-grade]
    (merge school 
           {in-grade (conj 
                      (grade school in-grade) 
                      name)}))

(defn sorted 
    [school] 
    (into (sorted-map)
      (map (fn [[grade names]]
             [grade (sort names)]) school)))