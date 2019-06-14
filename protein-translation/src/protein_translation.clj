(ns protein-translation)

(defn translate-codon 
    [codon] 
    ((->> {"Methionine"    ["AUG"]
           "Tryptophan"    ["UGG"]
           "Phenylalanine" ["UUU" "UUC"]
           "Leucine"       ["UUA" "UUG"]
           "Serine"        ["UCU" "UCC" "UCA" "UCG"]
           "Tyrosine"      ["UAU" "UAC"]
           "Cysteine"      ["UGU" "UGC"]
           "STOP"          ["UAA" "UAG" "UGA"]}
          (#(into {} (for [protein (keys %), codon (% protein)] 
                          [codon, protein])))
     )
     codon
    ))

(defn translate-rna 
    [rna]
    (->> rna
        ;  (partition 3) 
        ;  (map #(apply str %))
         (re-seq #"...")
         (map translate-codon)
         (take-while #(not= "STOP" %))
    ))
