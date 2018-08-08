(ns copicat.formats.nplusplus
  (:require [copicat.io-util :refer :all]))

(defn split-tile-data [tile-data]
  (map (partial apply str) (partition 2 tile-data)))

(defn get-tile-data-from-binary-file [file]
  (subvec (slurp-bytes file) 0xB8 0x47E))

(defn to-binary [text-level-data]
  (vec (map #(Integer/parseInt % 16) (split-tile-data text-level-data))))