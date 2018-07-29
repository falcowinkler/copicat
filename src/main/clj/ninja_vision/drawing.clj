(ns ninja-vision.drawing
  (:require [quil.core :refer :all]
            [ninja-vision.draw-data :refer :all]
            [ninja-vision.extraction :as e]))

(defn draw [level-data]
  (no-loop)
  (background 204 202 206)
  (fill 124 120 136)
  (stroke 124 120 136)
  (let [tile-data (e/split-tile-data level-data)]
    (doseq [[x y]
            (line-by-line-tile-iteration
              board-width board-height)
            forms
            (get-draw-forms tile-data
                            (index-for-coordinate x y))]
      (with-translation [(* d x) (* d y)]
                        (eval forms)))))



