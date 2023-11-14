(ns interest-is-interesting (:refer-clojure :exclude [abs]))

(defn- abs [x] (max x (- x)))

(defn interest-rate
  "Calculate interest rate based on current balance"
    [balance]
    (condp > balance
        0    -3.213
        1000 0.5
        5000 1.621
             2.475))

(defn annual-balance-update
  "Update balance with accrued interest"
  [balance]
  (+ balance (* 0.01M balance (->> balance 
                                   (interest-rate) 
                                   (abs) 
                                   (bigdec)))))

(defn amount-to-donate
  "Calculate the amount that can be donated for a balance and the tax free rate"
  [balance tax-free-percentage]
  (max 0 (->> balance 
              (* 2M) 
              (* 0.01) 
              (* (-> tax-free-percentage bigdec)) 
              (int))))