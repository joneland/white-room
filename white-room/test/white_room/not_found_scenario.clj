(ns white-room.not-found-scenario
  (:use clojure.test
   :require [clj-http.client :as client]))

(deftest ^:behaviour resource-not-found-scenario 
  (testing "Generates a 404 when URI does not exist"
    (let [response  (client/get "http://localhost:4000" {:throw-exceptions? false})]
      (is (= 404 (:status response))))))
