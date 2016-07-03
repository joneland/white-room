(ns white-room.handler-test
  (:use clojure.test
        ring.mock.request
        white-room.handler))

(deftest endpoints

  (testing "endpoint not found"
    (let [response (app (request :get "/dummy-route-that-doesnt-exist"))]
      (is (= 404 (:status response)))
      (is (= "application/json; charset=utf-8" (get-in response [:headers "Content-Type"])))
      (is (= "{\"message\":\"Resource not found!\"}" (:body response))))))