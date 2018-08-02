(ns ninja-vision.draw-data
  (:require [quil.core :refer :all]
            [ninja-vision.code-to-tile :refer :all]))

(def board-height 23)
(def board-with-n++ 42)
(def board-width-n 31)

(defn is-n++-format [tile-count]
  (= tile-count (* board-height board-with-n++)))

;the iteration order is different for the versions
;row-by-row for n++
;column-by-column for n
(defn line-by-line-tile-iteration [count]
  (if (is-n++-format count)
    (for [y (range board-height) x (range board-with-n++)]
      [x y])
    (for [x (range board-width-n) y (range board-height)]
      [x y])))

(defn index-for-coordinate [x y count]
  (if (is-n++-format count)
    (+ (* y board-with-n++) x)
    (+ (* x board-height) y)))

(defn get-draw-forms [tile-data index]
  (get tile-code-to-draw-forms
       (nth tile-data index)))