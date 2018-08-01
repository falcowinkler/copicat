(ns ninja-vision.drawing
  (:require [quil.core :refer :all]
            [ninja-vision.draw-data :refer :all]
            [ninja-vision.code-to-tile :refer :all]))

(defn draw [tile-data format]
  (background 204 202 206)
  (doseq [[x y]
          (line-by-line-tile-iteration
            board-width board-height)
          forms
          (get-draw-forms tile-data
                          (index-for-coordinate x y) format)]
    (with-translation [(* d x) (* d y)]
                      (eval forms))))

(defn draw-and-save [filename-to-tile-data format]
  (fill 124 120 136)
  (no-stroke)
  (no-loop)
  (doseq [[path-to-file tile-data]  filename-to-tile-data]

    (draw tile-data format)
    (save (str path-to-file ".png"))
    (println (str "Saved image >> " path-to-file ".png")))
  (exit))

(defn save-images [filename-to-tile-data format]
  (sketch
    :size [1260 690]
    :draw (partial draw-and-save filename-to-tile-data format)))