(ns ninja-vision.code-to-tile
  (:require [quil.core :refer :all]))

(def d 30)

(def block `((rect 0 0 d d)))
(def empty-tile `())

(def triangle-q `((triangle 0 d d 0 d d)))
(def triangle-w `((triangle 0 0 0 d d d)))
(def triangle-a `((triangle 0 0 d 0 d d)))
(def triangle-s `((triangle 0 0 0 d d 0)))

(def half-triangle-q `((triangle 0 d d (/ d 2) d d)))
(def half-triangle-w `((triangle 0 (/ d 2) 0 d d d)))
(def half-triangle-a `((triangle 0 0 d (/ d 2) d 0)))
(def half-triangle-s `((triangle 0 0 0 (/ d 2) d 0)))

(def slab-triangle-q `((do
                         (rect 0 (/ d 2) d (/ d 2))
                         (triangle 0 (/ d 2) d 0 d (/ d 2)))))
(def slab-triangle-w `((do
                         (rect 0 (/ d 2) d (/ d 2))
                         (triangle 0 0 d (/ d 2) 0 (/ d 2)))))
(def slab-triangle-a `((do
                         (rect 0 0 d (/ d 2))
                         (triangle 0 (/ d 2) d (/ d 2) d d))))
(def slab-triangle-s `((do
                         (rect 0 0 d (/ d 2))
                         (triangle 0 (/ d 2) d (/ d 2) 0 d))))

(def spike-triangle-q `((triangle (/ d 2) d d 0 d d)))
(def spike-triangle-w `((triangle 0 0 0 d (/ d 2) d)))
(def spike-triangle-a `((triangle (/ d 2) 0 d 0 d d)))
(def spike-triangle-s `((triangle 0 0 (/ d 2) 0 0 d)))

(def side-slab-triangle-q `((do
                              (rect (/ d 2) 0 (/ d 2) d)
                              (triangle 0 d (/ d 2) 0 (/ d 2) d))))
(def side-slab-triangle-w `((do
                              (rect 0 0 (/ d 2) d)
                              (triangle (/ d 2) 0 (/ d 2) d d d))))
(def side-slab-triangle-a `((do
                              (rect (/ d 2) 0 (/ d 2) d)
                              (triangle 0 0 (/ d 2) 0 (/ d 2) d))))
(def side-slab-triangle-s `((do
                              (rect 0 0 (/ d 2) d)
                              (triangle (/ d 2) 0 (/ d 2) d d 0))))

(def boob-q `((arc d d (* d 2) (* d 2) PI (+ PI HALF-PI))))
(def boob-w `((arc 0 d (* d 2) (* d 2) (+ PI HALF-PI) (* 2 PI))))
(def boob-a `((arc d 0 (* d 2) (* d 2) HALF-PI PI)))
(def boob-s `((arc 0 0 (* d 2) (* d 2) 0 HALF-PI)))

(def arc-q `((begin-shape)
              (vertex d d)
              (bezier-vertex d d d 0 d 0)
              (bezier-vertex d d 0 d 0 d)
              (end-shape)))
(def arc-w `((begin-shape)
              (vertex 0 d)
              (bezier-vertex 0 0 0 d 0 0)
              (bezier-vertex 0 d d d d d)
              (end-shape)))
(def arc-a `((begin-shape)
              (vertex d 0)
              (bezier-vertex d d d 0 d d)
              (bezier-vertex d 0 0 0 0 0)
              (end-shape)))
(def arc-s `((begin-shape)
              (vertex 0 0)
              (bezier-vertex 0 0 d 0 d 0)
              (bezier-vertex 0 0 0 d 0 d)
              (end-shape)))

(def slab-q `((rect 0 0 (/ d 2) d)))
(def slab-w `((rect 0 0 d (/ d 2))))
(def slab-a `((rect 0 (/ d 2) d (/ d 2))))
(def slab-s `((rect (/ d 2) 0 (/ d 2) d)))

(def tile-code-to-draw-forms
  {:binary
   {0x00 empty-tile
    0x01 block
    0x02 slab-w
    0x03 slab-s
    0x04 slab-a
    0x05 slab-q
    0x06 triangle-s
    0x07 triangle-a
    0x08 triangle-q
    0x09 triangle-w
    0x0a boob-s
    0x0b boob-a
    0x0c boob-q
    0x0d boob-w
    0x0e arc-s
    0x0f arc-a
    0x10 arc-q
    0x11 arc-w
    0x12 half-triangle-s
    0x13 half-triangle-a
    0x14 half-triangle-q
    0x15 half-triangle-w
    0x16 slab-triangle-s
    0x17 slab-triangle-a
    0x18 slab-triangle-q
    0x19 slab-triangle-w
    0x1a spike-triangle-s
    0x1b spike-triangle-a
    0x1c spike-triangle-q
    0x1d spike-triangle-w
    0x1e side-slab-triangle-s
    0x1f side-slab-triangle-a
    0x20 side-slab-triangle-q
    0x21 side-slab-triangle-w
    }
   :text
   {0x00 empty-tile
    0x01 block
    0x02 slab-w
    0x03 slab-s
    0x04 slab-a
    0x05 slab-q
    0x06 triangle-s
    0x07 triangle-a
    0x08 triangle-q
    0x09 triangle-w
    0x0a boob-s
    0x0b boob-a
    0x0c boob-q
    0x0d boob-w
    0x0e arc-s
    0x0f side-slab-triangle-a
    0x10 arc-q
    0x11 arc-w
    0x12 half-triangle-s
    0x13 half-triangle-a
    0x14 half-triangle-q
    0x15 half-triangle-w
    0x16 slab-triangle-s
    0x17 slab-triangle-a
    0x18 slab-triangle-q
    0x19 slab-triangle-w
    0x1a spike-triangle-s
    0x1b spike-triangle-a
    0x1c spike-triangle-q
    0x1d spike-triangle-w
    0x1e side-slab-triangle-s
    0x1f empty-tile
    0x20 side-slab-triangle-q
    0x21 block
    }})