(ns rna-transcription)

(def dna-pattern #"[GCAT]+")

(def dna->rna {\T "A", \A "U", \C "G", \G "C"})

(defn dna?
    "Checks a sequence of nucleotides
     against the dna pattern to determine match"
    [sequence]
    (re-matches dna-pattern sequence))

(defn to-rna
    "Checks if a sequence is actually dna
     and then maps into the corresponding rna"
    [sequence] 
    (assert (dna? sequence))
    (apply str (map dna->rna sequence)))
