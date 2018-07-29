(ns ninja-vision.draw-data
  (:require [quil.core :refer :all]))

(def d 30)

(def tile-code-to-draw-forms
  {:fill-mode
   {0x00 '()
    0x01
         `((rect 0 0 d d))
    0x08 `((triangle 0 d d 0 d d))
    0x09
         `((triangle 0 0 0 d d d))
    0x07
         `((triangle 0 0 d 0 d d))
    0x06
         `((triangle 0 0 0 d d 0))
    0x14
         `((triangle 0 d d (/ d 2) d d))
    0x15
         `((triangle 0 (/ d 2) 0 d d d))
    0x13
         `((triangle 0 0 d (/ d 2) d 0))
    0x12
         `((triangle 0 0 0 (/ d 2) d 0))
    0x18
         `((do
             (rect 0 (/ d 2) d (/ d 2))
             (triangle 0 (/ d 2) d 0 d (/ d 2))))
    0x19
         `((do
             (rect 0 (/ d 2) d (/ d 2))
             (triangle 0 0 d (/ d 2) 0 (/ d 2))))
    0x17
         `((do
             (rect 0 0 d (/ d 2))
             (triangle 0 (/ d 2) d (/ d 2) d d)))
    0x16
         `((do
             (rect 0 0 d (/ d 2))
             (triangle 0 (/ d 2) d (/ d 2) 0 d)))
    0x1c
         `((triangle (/ d 2) d d 0 d d))
    0x1d
         `((triangle 0 0 0 d (/ d 2) d))
    0x1b
         `((triangle (/ d 2) 0 d 0 d d))
    0x1a
         `((triangle 0 0 (/ d 2) 0 0 d))
    0x20
         `((do
             (rect (/ d 2) 0 (/ d 2) d)
             (triangle 0 d (/ d 2) 0 (/ d 2) d)))
    0x21
         `((do
             (rect 0 0 (/ d 2) d)
             (triangle (/ d 2) 0 (/ d 2) d d d)))
    0x1f
         `((do
             (rect (/ d 2) 0 (/ d 2) d)
             (triangle 0 0 (/ d 2) 0 (/ d 2) d)))
    0x1e
         `((do
             (rect 0 0 (/ d 2) d)
             (triangle (/ d 2) 0 (/ d 2) d d 0)))
    0x0c
         `((arc d d (* d 2) (* d 2) PI (+ PI HALF-PI)))
    0x0d
         `((arc 0 d (* d 2) (* d 2) (+ PI HALF-PI) (* 2 PI)))
    0x0b
         `((arc d 0 (* d 2) (* d 2) HALF-PI PI))
    0x0a
         `((arc 0 0 (* d 2) (* d 2) 0 HALF-PI))

    0x10 `((begin-shape)
           (vertex d d)
           (bezier-vertex d d d 0 d 0)
           (bezier-vertex d d 0 d 0 d)
           (end-shape))
    0x11 `((begin-shape)
           (vertex 0 d)
           (bezier-vertex 0 0 0 d 0 0)
           (bezier-vertex 0 d d d d d)
           (end-shape))
    0x0f `((begin-shape)
           (vertex d 0)
           (bezier-vertex d d d 0 d d)
           (bezier-vertex d 0 0 0 0 0)
           (end-shape))
    0x0e `((begin-shape)
           (vertex 0 0)
           (bezier-vertex 0 0 d 0 d 0)
           (bezier-vertex 0 0 0 d 0 d)
           (end-shape))
    0x05
         `((rect 0 0 (/ d 2) d))
    0x02
         `((rect 0 0 d (/ d 2)))
    0x04
         `((rect 0 (/ d 2) d (/ d 2)))
    0x03
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

