(ns white-room.handler-test
  (:use clojure.test
        ring.mock.request
        conjure.core
        white-room.handler
        white-room.scrape))

(deftest endpoints

  (testing "endpoint not found"
    (let [response (app (request :get "/dummy-route-that-doesnt-exist"))]
      (is (= 404 (:status response)))
      (is (= "application/json; charset=utf-8" (get-in response [:headers "Content-Type"])))))

  (testing "calls try-selector using query parameters"
    (stubbing [try-selector "stubbed response"]
      (let [response (app (request :get "/try?url=1&name-selector=2&status-selector=3"))]
        (is (= 200 (:status response)))
        (is (= "application/json; charset=utf-8" (get-in response [:headers "Content-Type"])))
        (verify-called-once-with-args try-selector "1" "2" "3")))))