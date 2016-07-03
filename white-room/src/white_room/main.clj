(ns white-room.main
  (:gen-class)
  (:require [org.httpkit.server :refer [run-server]]
            [white-room.handler :refer [app]]))

(def port (Integer/parseInt (or (System/getenv "PORT") "4000")))

(defn -main []
  (run-server app {:port port})
  (println (str "Listening on port " port)))