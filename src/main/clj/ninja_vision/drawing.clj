(ns ninja-vision.drawing
  (:require [quil.core :refer :all]
            [ninja-vision.draw-data :refer :all]
            [ninja-vision.code-to-tile :refer :all]
            [clojure.tools.logging :as log]))

(defn draw [tile-data]
  (background 204 202 206)
  (doseq [[x y]
          (line-by-line-tile-iteration (count tile-data))
          forms
          (get-draw-forms tile-data
                          (index-for-coordinate x y (count tile-data)))]
    (with-translation [(* d x) (* d y)]
                      (eval forms))))

(defn draw-and-save [filename-to-tile-data]
  (fill 124 120 136)
  (stroke 204 202 206)
  (no-loop)
  (doseq [[path-to-file tile-data] filename-to-tile-data]
    (draw tile-data)
    (save (str path-to-file ".png"))
    (log/info (str "Saved image " path-to-file ".png")))
  (exit))

(defn image-width [filename-to-tile-data]
  (if (is-n++-format
        (count (second (first filename-to-tile-data))))
    (* 42 d)
    (* 31 d)))

(defn save-images [filename-to-tile-data]
  (sketch
    :size [(image-width filename-to-tile-data) 690]
    :draw (partial draw-and-save filename-to-tile-data)))