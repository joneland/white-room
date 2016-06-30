(ns white-room.main
  (:require [org.httpkit.server :refer [run-server]]
            [white-room.handler :refer [app]])
  (:gen-class))

(defn -main []
  (let [port (Integer/parseInt (or (System/getenv "PORT") "8080"))]
    (run-server app {:port port})
    (println (str "Listening on port " port))))
