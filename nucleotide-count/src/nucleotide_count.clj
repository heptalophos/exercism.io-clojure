(ns nucleotide-count
  (:refer-clojure :exclude [count]))

(defn nucleotide-counts [strand] 
  (merge-with + {\G 0, \C 0, \T 0, \A 0} (frequencies strand)))

(defn count [nucleotide strand] 
  (if (contains? #{\G, \C, \T, \A, \U} nucleotide)
      ((nucleotide-counts strand) nucleotide 0)
      (throw (Exception. "Invalid nucleotide"))))
