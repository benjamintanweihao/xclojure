(ns anagram
  (:require [clojure.string :as str]))

(defn anagram-for? [left right]
  (let [l (str/lower-case left)
        r (str/lower-case right)]
    (and
     (not (= l r))
     (= (sort l) (sort r)))))

(defn anagrams-for [word candidates]
  (filter #(anagram-for? word %) candidates))
