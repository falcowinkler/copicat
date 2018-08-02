(ns ninja-vision.formats.nplusplus)

(defn split-tile-data [tile-data]
  (map (partial apply str) (partition 2 tile-data)))

(defn to-binary [text-level-data]
  (vec (map #(Integer/parseInt % 16) (split-tile-data text-level-data))))