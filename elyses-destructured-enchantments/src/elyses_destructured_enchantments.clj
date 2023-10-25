(ns elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [deck]
  (first deck))
  
#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn second-card
  "Returns the second card from deck."
  [deck]
  (let [[_ & rest] deck]
  (first-card rest)))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [deck]
  (let [[fst snd & rest] deck]
       (concat [snd] [fst] rest)))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn discard-top-card
  "Returns a vector containing the first card and
   a vector of the remaining cards in the deck."
  [deck]
  (let [[hd & rest] deck] 
       [hd rest]))

(def face-cards
  ["jack" "queen" "king"])

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [deck]
  (if (not (seq deck)) 
      face-cards
      (let [[hd & rest] deck]
          (concat [hd] face-cards rest))))
