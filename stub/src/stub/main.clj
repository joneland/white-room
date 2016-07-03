(ns stub.main
  (:gen-class)
  (:require [org.httpkit.server :refer [run-server]]
            [stub.handler :refer [app]]))

(def port (Integer/parseInt (or (System/getenv "PORT") "4001")))

(defn -main []
  (run-server app {:port port})
  (println (str "Stub listening on port " port)))