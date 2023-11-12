(ns etl 
  (:require [clojure.string :refer [lower-case]]))

(defn transform
  [source-system]
  (into {} 
        (for [[score letters] source-system letter letters]
             [(lower-case letter) score])))
