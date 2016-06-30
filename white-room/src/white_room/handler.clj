(ns white-room.handler
  (:require [org.httpkit.server :refer [run-server]]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.json :refer :all]
            [ring.util.response :refer [response]]))

(defroutes app-routes
  (route/not-found
   (response {:message "Resource not found!"})))

(def app
 (-> app-routes
     wrap-json-response
     wrap-json-body))
