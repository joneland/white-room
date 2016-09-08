(ns white-room.scrape
  (:require [net.cgrand.enlive-html :as html]))

(defn fetch-url [url]
  (html/html-resource (java.net.URL. url)))

(defn node-selector [resource selector]
  (map html/text (html/select resource selector)))

(defn zip [resource name-selector status-selector]
  (let [name (node-selector resource name-selector)
        status (node-selector resource status-selector)]
    (->>
      (map vector name status)
      (map (fn [item] (zipmap [:name :status] item))))))


;; Sample Data

(def avoriaz-piste-url "http://www.skiplan.com/bulletin/bulletin.php?station=avoriaz&region=alpes&pays=france&lang=en")
(def avoriaz-piste-name-selector [:li.piste [:span (html/nth-child 3)]])
(def avoriaz-piste-status-selector [:li.piste #{:div.etat :div.ferme}])

(def avoriaz-lifts-url "http://www.skiplan.com/bulletin/bulletin.php?station=avoriaz&region=alpes&pays=france&lang=en")
(def avoriaz-lifts-name-selector [:li.rm (html/nth-child 3)])
(def avoriaz-lifts-status-selector [:li.rm #{:div.etat :div.ferme}])

(defn avoriaz-pistes []
  (->
    (fetch-url avoriaz-piste-url)
    (zip avoriaz-piste-name-selector avoriaz-piste-status-selector)))

(defn avoriaz-lifts []
  (->
    (fetch-url avoriaz-lifts-url)
    (zip avoriaz-lifts-name-selector avoriaz-lifts-status-selector)))