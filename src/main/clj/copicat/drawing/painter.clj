(ns copicat.drawing.painter
  (:require [quil.core :refer :all]
            [copicat.drawing.draw-data :refer :all]
            [copicat.drawing.code-to-tile :refer :all]
            [clojure.tools.logging :as log]
            [copicat.extraction-util :as e]))

(defn draw [tile-data]
  (background 204 202 206)
  (doseq [[x y]
          (line-by-line-tile-iteration (count tile-data))
          forms
          (get-draw-forms tile-data
                          (index-for-coordinate x y (count tile-data)))]
    (with-translation [(* d x) (* d y)]
                      (eval forms))))

(defn full-output-path [level output-path]
  (str output-path "/" (e/cleanup_level_name (:level-name level)) ".png"))

(defn draw-and-save [data-list output-path]
  (fill 124 120 136)
  (stroke 204 202 206)
  (no-loop)
  (doseq [level data-list]
    (let [full-path (full-output-path level output-path)]
      (draw (:tile-data level))
      (save full-path)
      (log/info (str "Saved image to " full-path))))
  (exit))

(defn image-width [data-sample]
  (* d (/ (count data-sample) board-height)))

(defn save-images [data-list output-path]
  (sketch
    :size [(image-width (:tile-data (first data-list))) (* board-height d)]
    :draw (partial draw-and-save data-list output-path)))