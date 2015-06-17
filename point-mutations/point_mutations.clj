(ns point-mutations)

(defn different?  [pair]
  (let [[left right] pair]
    (not (= left right))))

(defn hamming-distance
  [left right]
  (if (= (count left) (count right))
    (count (filter #(different? %) (map vector left right)))
    nil))
