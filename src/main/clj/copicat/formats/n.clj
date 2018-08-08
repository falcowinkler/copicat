(ns copicat.formats.n
  (:require [clojure.core.matrix :as m]
            [copicat.extraction-util :as e]))

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

(defn extract-tile-data [level-string]
  (e/extract-tile-data level-string #".*#.*#.*#([0-9A-Q@;:y=?<>]{713,})"))

(defn to-binary [level-string]
  (-> (map n-code-to-binary (extract-tile-data level-string))
      (m/reshape  [31 23])
      (m/transpose)
      (m/reshape  [(* 31 23)])))