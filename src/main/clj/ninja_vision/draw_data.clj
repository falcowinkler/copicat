(ns ninja-vision.draw-data
  (:require [quil.core :refer :all]))

(def d 30)

(def tile-code-to-draw-forms
  {:fill-mode
   {"00" '()
    "01"
         `((rect 0 0 d d))
    "08"
         `((triangle 0 d d 0 d d))
    "09"
         `((triangle 0 0 0 d d d))
    "07"
         `((triangle 0 0 d 0 d d))
    "06"
         `((triangle 0 0 0 d d 0))
    "14"
         `((triangle 0 d d (/ d 2) d d))
    "15"
         `((triangle 0 (/ d 2) 0 d d d))
    "13"
         `((triangle 0 0 d (/ d 2) d 0))
    "12"
         `((triangle 0 0 0 (/ d 2) d 0))
    "18"
         `((do
             (rect 0 (/ d 2) d (/ d 2))
             (triangle 0 (/ d 2) d 0 d (/ d 2))))
    "19"
         `((do
             (rect 0 (/ d 2) d (/ d 2))
             (triangle 0 0 d (/ d 2) 0 (/ d 2))))
    "17"
         `((do
             (rect 0 0 d (/ d 2))
             (triangle 0 (/ d 2) d (/ d 2) d d)))
    "16"
         `((do
             (rect 0 0 d (/ d 2))
             (triangle 0 (/ d 2) d (/ d 2) 0 d)))
    "1c"
         `((triangle (/ d 2) d d 0 d d))
    "1d"
         `((triangle 0 0 0 d (/ d 2) d))
    "1b"
         `((triangle (/ d 2) 0 d 0 d d))
    "1a"
         `((triangle 0 0 (/ d 2) 0 0 d))
    "20"
         `((do
             (rect (/ d 2) 0 (/ d 2) d)
             (triangle 0 d (/ d 2) 0 (/ d 2) d)))
    "21"
         `((do
             (rect 0 0 (/ d 2) d)
             (triangle (/ d 2) 0 (/ d 2) d d d)))
    "1f"
         `((do
             (rect (/ d 2) 0 (/ d 2) d)
             (triangle 0 0 (/ d 2) 0 (/ d 2) d)))
    "1e"
         `((do
             (rect 0 0 (/ d 2) d)
             (triangle (/ d 2) 0 (/ d 2) d d 0)))
    "0c"
         `((arc d d (* d 2) (* d 2) PI (+ PI HALF-PI)))
    "0d"
         `((arc 0 d (* d 2) (* d 2) (+ PI HALF-PI) (* 2 PI)))
    "0b"
         `((arc d 0 (* d 2) (* d 2) HALF-PI PI))
    "0a"
         `((arc 0 0 (* d 2) (* d 2) 0 HALF-PI))

    "10" `((begin-shape)
           (vertex d d)
           (bezier-vertex d d d 0 d 0)
           (bezier-vertex d d 0 d 0 d)
           (end-shape))
    "11" `((begin-shape)
           (vertex 0 d)
           (bezier-vertex 0 0 0 d 0 0)
           (bezier-vertex 0 d d d d d)
           (end-shape))
    "0f" `((begin-shape)
           (vertex d 0)
           (bezier-vertex d d d 0 d d)
           (bezier-vertex d 0 0 0 0 0)
           (end-shape))
    "0e" `((begin-shape)
           (vertex 0 0)
           (bezier-vertex 0 0 d 0 d 0)
           (bezier-vertex 0 0 0 d 0 d)
           (end-shape))
    "05"
         `((rect 0 0 (/ d 2) d))
    "02"
         `((rect 0 0 d (/ d 2)))
    "04"
         `((rect 0 (/ d 2) d (/ d 2)))
    "03"
         `((rect (/ d 2) 0 (/ d 2) d))}})



(def board-width 42)
(def board-height 23)

(defn line-by-line-tile-iteration [width height]
  (for [y (range height) x (range width)]
    [x y]))

(defn index-for-coordinate [x y]
  (+ (* y board-width) x))

(defn get-draw-forms [tile-data index]
  (get (:fill-mode tile-code-to-draw-forms) (nth tile-data index)))

