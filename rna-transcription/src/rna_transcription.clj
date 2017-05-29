(ns rna-transcription)

(def dna->rna {\T "A", \A "U", \C "G", \G "C"})

(defn dna? [sequence]
    (re-matches #"[GCAT]+" sequence))

(defn to-rna [sequence] 
    (assert (dna? sequence))
    (apply str (map dna->rna sequence)))