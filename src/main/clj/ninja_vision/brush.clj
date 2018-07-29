(ns ninja-vision.brush
  (:require [quil.core :as q]
            [ninja-vision.draw-data :as d] [ninja-vision.extraction :as e]))


;23 * 42 board
(def board-width 42)
(def board-height 23)

(defn line-by-line-tile-iteration [width height]
  (for [y (range height) x (range width)]
    [x y]))

(defn index-for-coordinate [x y]
  (+ (* y board-width) x))

(defn get-lines [tile-data index]
  (:lines (get d/data-to-draw-data (nth tile-data index))))



(defn draw [leveldata]
  (q/no-loop)
  (let [tile-data (e/split-tile-data leveldata)]
    (doseq [[x y]
            (line-by-line-tile-iteration
              board-width board-height)
            [x1 y1 x2 y2]
            (get-lines tile-data
              (index-for-coordinate x y))]
      (q/line (+ x1 (* d/dim x))
              (+ y1 (* d/dim y))
              (+ x2 (* d/dim x))
              (+ y2 (* d/dim y))))))






