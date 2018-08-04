(defproject copicat "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [quil "2.7.1"]
                 [org.clojure/tools.cli "0.3.7"]
                 [org.clojure/tools.logging "0.4.0"]
                 [ch.qos.logback/logback-classic "1.1.3"]
                 [clojusc/protobuf "3.5.1-v1.1"]
                 [compliment "0.3.6"]]
  :main ^:skip-aot copicat.core
  :target-path "target/default"
  :profiles {:uberjar {:aot :all}
             :dev {:java-source-paths ["src/main/java"]}}
  :source-paths ["src/main/clj"]
  :test-paths ["src/test/clj"]
  :resource-paths ["resources"])

