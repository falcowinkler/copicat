(ns ninja-vision.core
  (:gen-class)
  (:require [quil.core :as q]
            [ninja-vision.drawing :refer :all]
            [clojure.java.io :refer :all]
            [ninja-vision.extraction :refer :all]))

(defn -main
  [& args])
(let [test-data (slurp (resource "sample_data.txt"))
      tile-data (extract-tile-data test-data)]
  (q/sketch
    :size [1260 690]
    :draw (partial draw tile-data)))

