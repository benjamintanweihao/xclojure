(ns etl)
 
(defn zip [left right]
  (map vector left right))
 
(defn transform [data]
  (into (sorted-map)
    (vec
      (map #(vec %)
        (partition 2
          (flatten
            (for [[points words] data]
              (zip
                (map clojure.string/lower-case words)
                (repeat (count words) points)))))))))
