(ns nucleotide-count
  (:refer-clojure :exclude [count]))

(def dna-nucleotides {\G 0, \C 0, \T 0, \A 0})

(defn nucleotide-counts 
  [strand] 
  (merge-with + dna-nucleotides (frequencies strand)))

(defn count-of-nucleotide-in-strand 
  [nucleotide strand] 
  {:pre [(contains? dna-nucleotides nucleotide)]}
  ((nucleotide-counts strand) nucleotide 0))