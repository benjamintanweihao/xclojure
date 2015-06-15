(ns nucleotide-count)

(defn validate-nucleotide
  [nucleotide]
  (when-not
    (some #(= nucleotide %) '(\A \T \G \C))
    (throw (Exception. "invalid nucleotide"))))

(defn count
  [nucleotide strand]
  (validate-nucleotide nucleotide)
  (clojure.core/count (filter #(= nucleotide % ) strand)))

(defn nucleotide-counts
  [strand]
  {\A (count \A strand)
   \T (count \T strand)
   \G (count \G strand)
   \C (count \C strand)})
