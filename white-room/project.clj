(defproject white-room "0.1-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring/ring-core "1.5.0"]
                 [ring/ring-jetty-adapter "1.5.0"]
                 [ring/ring-json "0.4.0"]
                 [compojure "1.5.1"]]

  :plugins [[lein-ring "0.9.7"]]  

  :ring {:handler white-room.handler/app}

  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
