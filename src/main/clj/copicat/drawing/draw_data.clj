(ns copicat.drawing.draw-data
  (:require [quil.core :refer :all]
            [copicat.drawing.code-to-tile :refer :all]))

(def board-height 23)
(defn board-with [data-count] (/ data-count board-height))

;the iteration order is different for the versions
;row-by-row for n++
;column-by-column for n
(defn line-by-line-tile-iteration [count]
    (for [y (range board-height) x (range (board-with count))]
      [x y]))

(defn index-for-coordinate [x y count]
    (+ (* y (board-with count)) x))

(defn get-draw-forms [tile-data index]
  (get tile-code-to-draw-forms
       (nth tile-data index)))