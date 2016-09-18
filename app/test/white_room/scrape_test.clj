(ns white-room.scrape-test
  (:use clojure.test
   :require [white-room.scrape :as scrape :refer [zip]]
            [net.cgrand.enlive-html :as html :refer [html-snippet]]))

(deftest testing-zip

  (testing "zips name and status with contents of matching selector"
    (let [html-sample (html/html-snippet
                        "<html>
                          <body>
                            <ul>
                              <li class=\"rm\">
                                <div class=\"etat ferme\">CLOSED</div>
                                <span class=\"img\" />
                                <span>TPH PRODAINS 3S</span>
                              </li>
                              <li class=\"rm\">
                                <div class=\"etat ferme\">OPEN</div>
                                <span class=\"img\" />
                                <span>TD6 GRANDES COMBES</span>
                              </li>
                            </ul>
                          </body>
                        </html")]
      (is (= [
              {:name "TPH PRODAINS 3S" :status "CLOSED"}
              {:name "TD6 GRANDES COMBES" :status "OPEN"}
             ]
            (scrape/zip html-sample "[:li.rm (nth-child 3)]" "[:li.rm #{:div.etat :div.ferme}]"))))))