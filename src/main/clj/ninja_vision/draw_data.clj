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
