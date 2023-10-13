(ns squeaky-clean
  (:require [clojure.string :refer [replace capitalize]]))

(defn clean
  "TODO: add docstring"
  [s]
  (-> s
      (replace #"\s" "_")                                         ; replace whitespace
      (replace #"[\u0000-\u001F]|[\u007F-\u009F]" "CTRL")         ; replace control chars
      (replace #"-(.)" #(capitalize (%1 1)))                      ; convert kebab to camel
      (replace #"[^_A-Za-z]" "")                                  ; remove non letters
      (replace #"[\p{IsGreek}&&\p{IsLowercase}]" ""))             ; remove α to ω
        ;; (remove #(<= (int \α) (int %) (int \ω))))
)
