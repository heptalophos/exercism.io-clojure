(ns bank-account)

(defn open-account 
    []
    (atom {:balance 0 :live true}))

(defn close-account 
    [account]
    (if (@account :live) 
        (swap! account assoc :live false)
        (throw (Exception. "Account is already closed"))))

(defn get-balance 
    [account]
    (if (@account :live)
        (@account :balance)
        nil))

(defn update-balance 
    [account amount]
    (if (@account :live) 
        (swap! account update-in [:balance] (fn [_] (+ _ amount)))
        (throw (Exception. "Can't update: account is closed"))))