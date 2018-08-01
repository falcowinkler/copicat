(ns ninja-vision.extraction
  (:require
    [ninja-vision.io :refer :all]))

(def tile-data-regex #"\$.+#0000000([0-9a-f].{1932})")
(def level-name-regex #"(?<=\$)(.*?)(?=\#)")

(defn extract-tile-data [level-data]
  (let [matcher (re-matcher tile-data-regex level-data)]
    (re-find matcher)
    (second (re-groups matcher))))

(defn extract-level-name [level-data]
  (first (re-find (re-matcher level-name-regex level-data))))

(defn split-tile-data [tile-data]
  (map (partial apply str) (partition 2 tile-data)))

(defn string-tile-data-to-binary [tile-data]
  (vec (map #(Integer/parseInt % 16) (split-tile-data tile-data))))

(defn get-tile-data-from-binary-file [file]
  (subvec (slurp-bytes file) 0xB8 0x47E))

(defn get-name-data-list [input-path output-path input-format]

    (case
      input-format
      :binary
      (for [file (get-file-or-files input-path)]
        [(str output-path "/" (.getName file))
         (get-tile-data-from-binary-file file)])
      :text
      (for [file (get-file-or-files input-path)
            line (get-lines-from-file file)]
        [(str output-path "/" (extract-level-name line))
         (string-tile-data-to-binary (extract-tile-data line))])))
