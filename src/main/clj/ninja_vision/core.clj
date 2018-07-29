(ns ninja-vision.core
  (:gen-class)
  (:require [quil.core :as q]
            [ninja-vision.brush :refer :all]
            [clojure.java.io :refer :all]
            [ninja-vision.extraction :refer :all]))

(defn -main
  [& args]

  (println "Hello, World!"))

(let [testdata (slurp (resource "sample_data.txt"))
      tiledata (extract-tile-data testdata)]
  (q/sketch
    :size [1260 690]
    :draw (partial draw tiledata)))

