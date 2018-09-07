(ns bracket-push)

(defn valid? [s]
    (->> s
        (filter #{\[ \] \( \) \{ \}})
        (reduce
            (fn [stack item]
                (cond
                    (#{ \( \{ \[ } item) (conj stack item)
                    (and (#{ \( \{ \[ } (last stack))
                         (= ({ \) \(, \} \{, \] \[ } item) (last stack)))
                    (pop stack)
                    :else (conj stack item)))
        [])
    empty?))
