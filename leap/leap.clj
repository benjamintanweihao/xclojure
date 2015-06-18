(ns leap)
 
(defn evenly-divisible-by? [num div]
  (= (mod num div) 0))
 
(defn leap-year? [year]
  (and (evenly-divisible-by? year 4)
       (or
         (not (evenly-divisible-by? year 100))
         (evenly-divisible-by? year 400))))
