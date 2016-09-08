(ns white-room.behaviour-tests
  (:use clojure.test
   :require [clj-http.client :as client]))

(deftest ^:behaviour resource-not-found-scenario 
  (testing "Generates a 404 when URI does not exist"
    (let [response  (client/get "http://localhost:4000/lets-see-what-lives-here" {:throw-exceptions? false})]
      (is (= 404 (:status response))))))