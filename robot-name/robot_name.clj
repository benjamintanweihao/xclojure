(ns robot-name)

(defn rand-alpha []
   (rand-nth (into [] (map char (range 65 91)))))

(defn robot []
  (apply str
    (concat
      (repeatedly 2 #(rand-alpha))
      (repeatedly 3 #(rand-int 10)))))

(defn robot-name [name] name)

(defn reset-name [name]
  (alter-var-root #'name robot))
