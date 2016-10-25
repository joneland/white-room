(ns white-room.handler
  (:require [org.httpkit.server :refer [run-server]]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [compojure.handler :refer :all]
            [ring.middleware.json :refer :all]
            [ring.util.codec :refer :all]
            [ring.util.response :refer [resource-response response]]
            [white-room.scrape :refer [status url]]))

(defn try-selector [encoded-uri encoded-name-selector encoded-status-selector]
  (let [uri             (url-decode encoded-uri)
        name-selector   (form-decode encoded-name-selector)
        status-selector (form-decode encoded-status-selector)]
    (status (url uri) name-selector status-selector)))

(defroutes app-routes
  (GET "/try" []
    (resource-response "try.html" {:root "public"}))
  (GET "/try-selector" {params :params}
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