(ns card-games)

(defn rounds
  "Takes the current round number and returns 
   a `list` with that round and the _next two_."
  [n]
  (range n (+ n 3)))

(defn concat-rounds
  "Takes two lists and returns a single `list` 
   consisting of all the rounds in the first `list`, 
   followed by all the rounds in the second `list`"
  [l1 l2]
  (apply list (concat l1 l2)))

(defn contains-round? 
  "Takes a list of rounds played and a round number.
   Returns `true` if the round is in the list, `false` if not."
  [l n]
  (boolean (some (fn [_] (= _ n)) l)))

(defn card-average
  "Returns the average value of a hand"
  [hand]
  (double (/ (apply + hand) (count hand))))

(defn approx-average?
  "Returns `true` if average is equal to either one of:
  - Take the average of the _first_ and _last_ number in the hand.
  - Using the median (middle card) of the hand."
  [hand]
  (let [first-card (first hand) last-card (last hand)
        total-cards (count hand) average (card-average hand)
        mean (/ (+ first-card last-card) 2.0)
        median (nth hand (/ total-cards 2))]
    (or (== average mean) (== average median))))

(defn average-even-odd?
  "Returns true if the average of the cards at even indexes 
   is the same as the average of the cards at odd indexes."
  [hand]
  (let [total-cards (count hand)
        even-idx-range (range 1 total-cards 2)
        odd-idx-range (range 0 total-cards 2)
        even (map (fn [i] (nth hand i)) even-idx-range)
        odds (map (fn [i] (nth hand i)) odd-idx-range)]
    (== (card-average even) (card-average odds))))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn maybe-double-last
  "If the last card is a Jack (11), doubles its value
   before returning the hand."
  [hand]
  (let [last-card (last hand) jack 11 
        all-but-Jack (drop-last hand)]
    (cond (== jack last-card)
              (concat all-but-Jack [(* jack 2)])
          :else
              hand)))
