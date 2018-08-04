(ns copicat.extraction
  (:require
    [copicat.io :refer :all]
    [copicat.formats.nplusplus :as n++]
    [copicat.formats.n :as n]
    [clojure.string :as string]))

(defn tile-data-regex [format]
  (case format
    :text-n++
    #"\$.+#0000000([0-9a-f].{1932})"
    :text-n
    #".*#.*#.*#([0-9A-P@;:y=?<>]{713,})"))

(def level-name-regex #"(?<=\$)(.*?)(?=\#)")

(defn extract-tile-data [level-data input-format]
  (let [matcher (re-matcher (tile-data-regex input-format) level-data)]
    (if (not (nil? (re-find matcher)))
      (second (re-groups matcher)))))

(defn extract-level-name [level-data]
  (if-let [result (re-find level-name-regex level-data)]
    (let [clean-result (string/replace (string/trim (first result)) "/" "-")]
      (if (> (count clean-result) 100) (subs clean-result 0 100) clean-result))))

(defn string-format-to-binary [string-data format]
  (if-let [tile-data (extract-tile-data string-data format)]
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
      (if-let [name (extract-level-name line)]
        [(str output-path "/" name)
         (string-format-to-binary line input-format)]))))