(ns white-room.scrape-test
  (:use clojure.test
        net.cgrand.enlive-html
        white-room.scrape))

(defn- to-resource [resource]
  (java.io.StringReader. resource))

(deftest zips-name-and-status

  (testing "returns contents of all matching nodes"
    (let [html-sample (str
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
    (is (= ["CLOSED" "OPEN"]
          (node-selector  (to-resource html-sample) "[:li.rm #{:div.etat :div.ferme}]")))
    (is (= ["TPH PRODAINS 3S" "TD6 GRANDES COMBES"]
          (node-selector (to-resource html-sample) "[:li.rm (nth-child 3)]"))))))
