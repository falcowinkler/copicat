(ns ninja-vision.draw-data)

(def dim 30)

(def data-to-draw-data
  {"00"
   {:lines []
    :arcs  []}
   "10"
   {:lines
          [[0 0 0 dim]
           [0 0 dim 0]
           [dim 0 dim dim]
           [0 dim dim dim]]
    :arcs []}})

(def board-width 42)
(def board-height 23)

(defn line-by-line-tile-iteration [width height]
  (for [y (range height) x (range width)]
    [x y]))

(defn index-for-coordinate [x y]
  (+ (* y board-width) x))

(defn get-lines [tile-data index]
  (:lines (get data-to-draw-data (nth tile-data index))))
