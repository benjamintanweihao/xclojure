(ns word-count
  (:require [clojure.string :as str]))

(defn isLetterOrDigitOrWhitespace
  [char]
  (or (Character/isLetterOrDigit char) (Character/isWhitespace char)))

(defn word-count
  [text]
  (frequencies
   (str/split
    (str/lower-case
     (apply str (filter #(isLetterOrDigitOrWhitespace %) text))), #"\s+")))

(word-count "one fish two fish ref fish blue fish")
