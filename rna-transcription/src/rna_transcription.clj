(ns rna-transcription)

(def dna->rna {\A "U", \C "G", \G "C", \T "A"})

(defn- to-rna
    "Checks if a sequence is actually dna
     and then maps into the corresponding rna"
    [sequence] 
    (->> sequence
         (map dna->rna)
         (apply str)))
