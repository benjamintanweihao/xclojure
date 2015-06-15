(ns rna-transcription)

(def dna-to-rna
  {\A \U
   \T \A
   \G \C
   \C \G})

(defn is-dna-nucleotide?
  [nucleotide]
  (contains? dna-to-rna nucleotide))

(defn validate-dna-sequence
  [sequence]
  (when-not (every? is-dna-nucleotide? sequence)
    (throw (AssertionError. "Invalid DNA Nucleotide"))))

(defn to-rna
  [sequence]
  (validate-dna-sequence sequence)
  (apply str (map dna-to-rna sequence)))
