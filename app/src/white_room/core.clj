(ns white-room.core
  (:require [net.cgrand.enlive-html :as html]))

(defn fetch-url [url]
  (html/html-resource (java.net.URL. url)))

(defn node-selector [url selector]
  (map html/text (html/select (fetch-url url) selector)))

(defn zip-pistes [url name-selector status-selector]
  (let [piste (node-selector url name-selector)
        status (node-selector url status-selector)]
    (->>
      (map vector piste status)
      (map (fn [item] (zipmap [:piste :status] item))))))

(defn zip-lifts [url name-selector status-selector]
  (let [lift (node-selector url name-selector)
        status (node-selector url status-selector)]
    (->>
      (map vector lift status)
      (map (fn [item] (zipmap [:lift :status] item))))))

(def avoriaz-piste-url "http://www.skiplan.com/bulletin/bulletin.php?station=avoriaz&region=alpes&pays=france&lang=en")
(def avoriaz-piste-name-selector [:li.piste [:span (html/nth-child 3)]])
(def avoriaz-piste-status-selector [:li.piste #{:div.etat :div.ferme}])


(def avoriaz-lifts-url "http://www.skiplan.com/bulletin/bulletin.php?station=avoriaz&region=alpes&pays=france&lang=en")
(def avoriaz-lifts-name-selector [:li.rm (html/nth-child 3)])
(def avoriaz-lifts-status-selector [:li.rm #{:div.etat :div.ferme}])

(defn avoriaz-pistes []
  (zip-pistes avoriaz-piste-url avoriaz-piste-name-selector avoriaz-piste-status-selector))

(defn avoriaz-lifts []
  (zip-lifts avoriaz-lifts-url avoriaz-lifts-name-selector avoriaz-lifts-status-selector))
