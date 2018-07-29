(ns ninja-vision.core
  (:gen-class)
  (:require [quil.core :as q]
            [ninja-vision.drawing :refer :all]
            [clojure.java.io :refer :all]
            [ninja-vision.extraction :refer :all]))

; args: --show


(defn -main
  [& args]
  (q/sketch
    :size [1260 690]
    :draw (partial draw (get-tile-data-from-byte-array "test"))))

