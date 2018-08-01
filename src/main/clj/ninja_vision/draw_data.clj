(ns ninja-vision.draw-data
  (:require [quil.core :refer :all] [ninja-vision.code-to-tile :refer :all]))

(def board-width 42)
(def board-height 23)

(defn line-by-line-tile-iteration [width height]
  (for [y (range height) x (range width)]
    [x y]))

(defn index-for-coordinate [x y]
  (+ (* y board-width) x))

(defn get-draw-forms [tile-data index format]
  (get (get tile-code-to-draw-forms format)
       (nth tile-data index)))