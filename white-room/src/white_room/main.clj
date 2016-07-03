(ns white-room.main
  (:require [org.httpkit.server :refer [run-server]]
            [white-room.handler :refer [app]])
  (:gen-class))

(def port (Integer/parseInt (or (System/getenv "PORT") "8080")))

(defn -main []
  (run-server app {:port port})
  (println (str "Listening on port " port)))
