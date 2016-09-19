(ns white-room.scrape
  (:require [net.cgrand.enlive-html :as html] ))

(defn url [url]
  (java.net.URL. url))

(defn- load-selector [selector]
  (binding [*ns* (find-ns 'net.cgrand.enlive-html)]
    (load-string selector)))

(defn- node-selector [resource selector]
  (map html/text (html/select (html/html-resource resource) (load-selector selector))))

(defn zip [resource name-selector status-selector]
  (let [name (node-selector resource name-selector)
        status (node-selector resource status-selector)]
    (->>
      (map vector name status)
      (map #(zipmap [:name :status] %)))))


;; Sample Data

(def avoriaz-piste-url "http://www.skiplan.com/bulletin/bulletin.php?station=avoriaz&region=alpes&pays=france&lang=en")
(def avoriaz-piste-name-selector "[:li.piste [:span (nth-child 3)]]")
(def avoriaz-piste-status-selector "[:li.piste #{:div.etat :div.ferme}]")

(def avoriaz-lifts-url "http://www.skiplan.com/bulletin/bulletin.php?station=avoriaz&region=alpes&pays=france&lang=en")
(def avoriaz-lifts-name-selector "[:li.rm (nth-child 3)]")
(def avoriaz-lifts-status-selector "[:li.rm #{:div.etat :div.ferme}]")

(defn avoriaz-pistes []
  (->
    (url avoriaz-piste-url)
    (zip avoriaz-piste-name-selector avoriaz-piste-status-selector)))

(defn avoriaz-lifts []
  (->
    (url avoriaz-lifts-url)
    (zip avoriaz-lifts-name-selector avoriaz-lifts-status-selector)))

;; Sample uri with query string
;; http://localhost:4000/try?url=http://www.skiplan.com/bulletin/bulletin.php?station=avoriaz%26region=alpes%26pays=france%26lang=en&name-selector=[:li.piste%20[:span%20(nth-child%203)]]&status-selector=[:li.piste%20%23{:div.etat%20:div.ferme}]