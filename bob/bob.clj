(ns bob
  (:require [clojure.string :as str]))

(defn filter-letters
  [str]
  (filter #(Character/isLetter %) str))

(defn all-uppercase?
  [chars]
  (every? #(Character/isUpperCase %) chars))

(defn mute?
  [sentence]
  (str/blank? sentence))

(defn shouting?
  [sentence]
  (let [filtered (filter-letters sentence)]
    (and (not-empty filtered) (all-uppercase? filtered))))

(defn question?
  [sentence]
  (= (last sentence) \?))

(defn response-for
  [sentence]
  (cond
    (mute? sentence) "Fine. Be that way!"
    (shouting? sentence) "Whoa, chill out!"
    (question? sentence) "Sure."
    :else "Whatever."))
