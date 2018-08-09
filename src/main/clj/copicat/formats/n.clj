(ns copicat.formats.n
  (:require [clojure.core.matrix :as m]
            [copicat.extraction-util :as e]
            [copicat.drawing.draw-data :refer :all]))

(def n-code-to-binary
  {\3 0x08
   \2 0x09
   \4 0x07
   \5 0x06
   \G 0x1c
   \F 0x1d
   \H 0x1b
   \I 0x1a
   \? 0x14
   \> 0x15
   \@ 0x13
   \A 0x12
   \7 0x10
   \6 0x11
   \8 0x0f
   \9 0x0e
   \Q 0x04
   \P 0x05
   \N 0x03
   \O 0x02
   \K 0x20
   \J 0x21
   \L 0x1f
   \M 0x1e
   \C 0x18
   \B 0x19
   \D 0x17
   \E 0x16
   \; 0x0c
   \: 0x0d
   \< 0x0b
   \= 0x0a
   \1 0x01
   \0 0x00})

(def binary-to-n-code
  (clojure.set/map-invert n-code-to-binary))

(defn extract-tile-data [level-string]
  (e/extract-tile-data level-string #".*#.*#.*#([0-9A-Q@;:y=?<>]{713})"))

(def board-width-n 31)

(defn to-binary [level-string]
  (if-let [tile-data (extract-tile-data level-string)]
    (-> (map n-code-to-binary tile-data)
        (m/reshape [board-width-n board-height])
        m/transpose
        (m/reshape [(* board-width-n board-height)]))))

(defn level-string-from-binary [n++-binary-format name]
  (assert (= (* board-width-n board-height)
             (count n++-binary-format))
          "n++ format to n level string not yet supported")
  (str
    "$"
    name
    "#Unknown#none#"
    (apply
      str
      (-> (map binary-to-n-code n++-binary-format)
          (m/reshape [board-height board-width-n])
          (m/transpose)
          (m/reshape [(* board-width-n board-height)])))
    "|"))

