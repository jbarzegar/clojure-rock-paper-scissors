(def outcome '("rock" "paper" "scissors"))

(defn human-won [h c]
  "Determin whether the human won the game"
  (or
   (and (= h "rock") (= c "scissors"))
   (and (= h "scissors") (= c "paper"))
   (and (= h "paper") (= c "rock"))))

(defn get-winner [h c]
  (cond (human-won h c)
        (do (println "You Won!" h "beats" c))
        :else
        (do (println "You lost :{" c "beats" h))))

(defn determineWin [human cpu]
  (cond (= human cpu)
        (do (println "Draw"))
        :else
        (do (get-winner human cpu))))

(defn fetchCpuObject []
  "Randomly get computer's object"
  (def index (rand-int (count outcome)))
  (nth outcome index))

(defn startGame [humanOutcome]
  "Initalize the start of the game"
  (def cpuOutcome (fetchCpuObject))
  (determineWin humanOutcome cpuOutcome))

(defn validateInput [choice]
  "Validates that input exists in possible outcomes"
  (def choiceInOutcome? (some #(= choice %) outcome))
  (cond (= true choiceInOutcome?)
        choice
        :else
        (println "Not a valid object" outcome)))

(defn -main []
  (println "pick your object" outcome)
  (let [pick (read-line)]
    (if (not (= nil (validateInput pick))) (startGame pick) (recur))))

(-main)
