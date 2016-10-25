(defproject white-room/app "0.1-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [http-kit "2.1.19"]
                 [ring/ring-core "1.5.0"]
                 [ring/ring-jetty-adapter "1.5.0"]
                 [ring/ring-json "0.4.0"]
                 [ring/ring-codec "1.0.1"]
                 [compojure "1.5.1"]
                 [org.clojure/data.json "0.2.6"]
                 [enlive "1.1.6"]]

  :main white-room.main
  :aot [white-room.main]

  :plugins [[lein-ring "0.9.7"]]

  :ring {:handler white-room.handler/app
         :port 4000}

  :profiles
    {:dev
      {:dependencies [[javax.servlet/servlet-api "2.5"]
                      [ring/ring-mock "0.3.0"]
                      [org.clojars.runa/conjure "2.1.3"]
                      [clj-http "2.2.0"]]}}

  :test-selectors {:default (complement :behaviour)
                   :behaviour :behaviour})
