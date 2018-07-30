(defproject ninja-vision "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [quil "2.7.1"]
                 [org.clojure/tools.cli "0.3.7"]]
  :main ^:skip-aot ninja-vision.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :source-paths ["src/main/clj"]
  :test-paths ["src/test/clj"]
  :resource-paths ["src/main/resources"])

