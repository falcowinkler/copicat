(ns copicat.extraction
  (:require
    [copicat.io :refer :all]
    [copicat.formats.nplusplus :as n++]
    [copicat.formats.n :as n]))

(defn tile-data-regex [format]
  (case format
    :text-n++
    #"\$.+#0000000([0-9a-f].{1932})"
    :text-n
    #"\$.*#.*#.*#(..{712})"))

(def level-name-regex #"(?<=\$)(.*?)(?=\#)")

(defn extract-tile-data [level-data input-format]
  (let [matcher (re-matcher (tile-data-regex input-format) level-data)]
    (re-find matcher)
    (second (re-groups matcher))))

(defn extract-level-name [level-data]
  (first (re-find (re-matcher level-name-regex level-data))))

(defn string-format-to-binary [string-data format]
  (let [tile-data (extract-tile-data string-data format)]
    (case format
      :text-n++
      (n++/to-binary tile-data)
      :text-n
      (n/to-binary tile-data))))

(defn get-tile-data-from-binary-file [file]
  (subvec (slurp-bytes file) 0xB8 0x47E))

(defn get-name-data-pairs [input-path output-path input-format]
  (case
    input-format
    :binary
    (for [file (get-file-or-files input-path)]
      [(str output-path "/" (.getName file))
       (get-tile-data-from-binary-file file)])
    (for [file (get-file-or-files input-path)
          line (get-lines-from-file file)]
      [(str output-path "/" (extract-level-name line))
       (string-format-to-binary line input-format)])))