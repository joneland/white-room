(ns white-room.main
  (:gen-class)
  (:require [org.httpkit.server :refer [run-server]]
            [white-room.handler :refer [app]]))

(def port 4000)

(defn -main []
  (run-server app {:port port})
  (println (str "Listening on port " port)))