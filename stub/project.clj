(defproject white-room/stub "0.1-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [http-kit "2.1.19"]
                 [ring/ring-core "1.5.0"]
                 [ring/ring-jetty-adapter "1.5.0"]
                 [ring/ring-json "0.4.0"]
                 [compojure "1.5.1"]]

  :main stub.main
  :aot [stub.main])