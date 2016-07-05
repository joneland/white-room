(ns stub.main
  (:gen-class)
  (:require [org.httpkit.server :refer [run-server]]
            [stub.handler :refer [app]]))

(def port 4001)

(defn -main []
  (run-server app {:port port})
  (println (str "Stub is now listening on port " port)))