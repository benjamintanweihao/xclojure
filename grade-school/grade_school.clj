(ns grade-school)
 
(defn add [db name grade]
  (assoc db grade (vec (distinct (concat (get db grade) [name])))))
 
(defn sorted [db]
  (into (sorted-map)
    (map vector (keys db) (map sort (vals db)))))
 
(defn grade [db grade]
  (or (get db grade) []))
