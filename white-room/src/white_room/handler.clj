(ns white-room.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]))

(defroutes app-routes
  (route/not-found "Not found!"))

(def app app-routes)
