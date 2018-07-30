(ns ninja-vision.io
  (:require
    [clojure.java.io :as io]))

(defn slurp-bytes
  [file]
  (with-open [out (java.io.ByteArrayOutputStream.)]
    (clojure.java.io/copy (clojure.java.io/input-stream file) out)
    (vec (.toByteArray out))))

(defn get-file-or-files [path]
  (if
    (.isDirectory (io/file path))
    (filter #(.isFile %) (file-seq (clojure.java.io/file path)))
    [(io/file path)]))
