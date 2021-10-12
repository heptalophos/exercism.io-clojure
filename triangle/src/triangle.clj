(ns triangle)

(defn triangle-type 
      [a b c] 
      (let [sorted (sort > [a b c])]
        (if (>= (first sorted) (apply + (rest sorted))) 
            :illogical 
            (case (count (set sorted))
                  1 :equilateral
                  2 :isosceles
                  3 :scalene))))

(defn equilateral?
      [a b c]
      (= (triangle-type a b c) :equilateral)
)

(defn isosceles?
      [a b c]
      (or 
      (= (triangle-type a b c) :equilateral)
      (= (triangle-type a b c) :isosceles))
)

(defn scalene?
      [a b c] 
      (= (triangle-type a b c) :scalene)
)