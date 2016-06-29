(defproject white-room "0.1-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring/ring-core "1.5.0"]
                 [ring/ring-jetty-adapter "1.5.0"]
                 [compojure "1.5.1"]]
  
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
