(ns ninja-vision.drawing
  (:require [quil.core :as q]
            [ninja-vision.draw-data :refer :all]
            [ninja-vision.extraction :as e]))



(defn draw [level-data]
  (q/no-loop)
  (q/background 255 255 255)
  (let [tile-data (e/split-tile-data level-data)]
    (doseq [[x y]
            (line-by-line-tile-iteration
              board-width board-height)
            [x1 y1 x2 y2]
            (get-lines tile-data
              (index-for-coordinate x y))]
      (q/line (+ x1 (* dim x))
              (+ y1 (* dim y))
              (+ x2 (* dim x))
              (+ y2 (* dim y))))))







