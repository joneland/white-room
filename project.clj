(defproject white-room/parent "0.1-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [http-kit "2.1.19"]
                 [ring/ring-core "1.5.0"]
                 [ring/ring-jetty-adapter "1.5.0"]
                 [ring/ring-json "0.4.0"]
                 [compojure "1.5.1"]]

;  :main white-room.main
;  :aot [white-room.main]

  :plugins [[lein-ring "0.9.7"]
            [lein-modules "0.3.11"]]

;  :ring {:handler white-room.handler/app
;         :port 4000}

  :profiles
    {:dev
      {:dependencies [[javax.servlet/servlet-api "2.5"]
                      [ring/ring-mock "0.3.0"]
                      [clj-http "2.2.0"]]}}

  :test-selectors {:default (complement :behaviour)
                   :behaviour :behaviour})
