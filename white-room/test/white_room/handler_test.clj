(ns white-room.handler-test
  (:use clojure.test
        ring.mock.request
        white-room.handler))

(deftest endpoints
  
  (testing "endpoint not found"
    (let [response (app (request :get "/dummy-route-that-doesnt-exist"))]
      (is (= (:status response) 404)))))
