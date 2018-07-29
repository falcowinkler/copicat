(ns ninja-vision.draw-data)

(def dim 30)

(def tile-code-to-draw-forms
  {:fill-mode
   {"00" '()
    "10"
    `((quil.core/rect 0 0 dim dim))}})

(def board-width 42)
(def board-height 23)

(defn line-by-line-tile-iteration [width height]
  (for [y (range height) x (range width)]
    [x y]))

(defn index-for-coordinate [x y]
  (+ (* y board-width) x))

(defn get-draw-forms [tile-data index]
   (get (:fill-mode tile-code-to-draw-forms) (nth tile-data index)))

