(ns ninja-vision.extraction)


(def tile-data-regex #"\$[a-z]+#00000000([0-9].{1932})")

(defn extract-tile-data [leveldata]
  (let [matcher (re-matcher tile-data-regex leveldata)]
    (re-find matcher)
    (second (re-groups matcher))))

(defn split-tile-data [tile-data]
  (map (partial apply str) (partition 2 tile-data)))