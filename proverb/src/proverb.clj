(ns proverb)


(defn- premises
    [[wanted lost]]
    (str "For want of a " wanted " the " lost " was lost." ))


(defn- conclusion
    [wanted]
    (str "And all for the want of a " wanted "."))


(defn recite 
    [things]
    (let [ prologue (mapv premises (partition 2 1 things))
           epilogue (conclusion (first things)) ]
    (cond (empty? things) ""
          :else (->> (#(interpose "\n" %) (conj prologue epilogue))
                     (apply str)))))