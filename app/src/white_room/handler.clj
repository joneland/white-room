(ns white-room.handler
  (:require [org.httpkit.server :refer [run-server]]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [compojure.handler :refer :all]
            [ring.middleware.json :refer :all]
            [ring.util.response :refer [response]]
            [white-room.scrape :refer [zip url]]))

(defn try-selector [uri name-selector status-selector]
  (zip (url uri) name-selector status-selector))

(defroutes app-routes
  (GET "/try" {params :params}
    (response {:result (try-selector (params :uri) (params :name-selector) (params :status-selector))}))
  (route/not-found
    (response {:message "Resource not found!"})))

(defn- wrap-log-request [handler]
  (fn [req]
    (println req)
    (handler req)))

(def app
  (-> app-routes
      compojure.handler/api
      wrap-log-request
      wrap-json-response
      wrap-json-body))