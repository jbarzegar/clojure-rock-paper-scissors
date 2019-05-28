(def names [{:name "james"} {:name "kacee"} {:name "alex"}])
(def numList [2 3 4 5 6])

(defn double
  "double incoming int"
  [int]
  (* int 2))

(defn add
  [x y]
  (* (+ x y) 2))

(defn doubleListInt
  [l]
  (map double l))

(defn readNames
  [nl]
  (doseq [i nl] (println "My name is:" (get i :name))))

(println (doubleListInt numList))

(readNames names)
