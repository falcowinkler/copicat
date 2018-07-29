(ns ninja-vision.drawing
  (:require [quil.core :refer :all]
            [ninja-vision.draw-data :refer :all]
            [ninja-vision.extraction :as e]))

(defn draw [level-data]
  (no-loop)
  (background 255 255 255)
  (let [tile-data (e/split-tile-data level-data)]
    (doseq [[x y]
            (line-by-line-tile-iteration
              board-width board-height)
            forms
            (get-draw-forms tile-data
                            (index-for-coordinate x y))]
      (with-translation [(* dim x) (* dim y)]
                        (println forms)
                        (eval forms)))))



