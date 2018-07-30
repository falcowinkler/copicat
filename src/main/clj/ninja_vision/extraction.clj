(ns ninja-vision.extraction
  (:require
    [ninja-vision.io :refer :all]))



(def tile-data-regex #"\$[a-z]+#00000000([0-9].{1932})")

(defn extract-tile-data [level-data]
  (let [matcher (re-matcher tile-data-regex level-data)]
    (re-find matcher)
    (second (re-groups matcher))))

(defn split-tile-data [tile-data]
  (map (partial apply str) (partition 2 tile-data)))



(defn get-tile-data-from-binary-file [file]
  (subvec (slurp-bytes file) 0xB8 0x47E))