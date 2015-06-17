(ns phone-number)
 
(defn number
  [raw]
  (let [numbers (filter #(Character/isDigit %) raw)]
    (cond
      (and
        (= (count numbers) 11)
        (= (first numbers) \1)) (apply str (rest numbers))
      (not (= (count numbers) 10)) "0000000000"
      :else (apply str numbers))))
 
(defn area-code
  [raw]
  (apply str (take 3 (number raw))))
 
(defn non-area-code-parts
  [raw]
  (let [parts (split-at 3 (apply str (drop 3 (number raw))))]
    (map #(apply str %) parts)))
 
(defn pretty-print
  [raw]
  (let [head (area-code raw)
        rest (non-area-code-parts raw)]
    (apply str ["(" head ") " (first rest) "-" (last rest)])))
