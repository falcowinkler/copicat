(ns copicat.io-util
  (:require
    [clojure.java.io :as io])
  (:import (com.google.protobuf ByteString)))

(defn slurp-bytes
  [file]
  (with-open [out (java.io.ByteArrayOutputStream.)]
    (clojure.java.io/copy (clojure.java.io/input-stream file) out)
    (vec (.toByteArray out))))

(defn get-file-or-files [path]
  (if
    (.isDirectory (io/file path))
    (vec (filter #(and (.isFile %)
                       (not (= ".DS_Store" (.getName %))))
                 (file-seq (clojure.java.io/file path))))
    [(io/file path)]))

(defn get-lines-from-file [file]
  (with-open [reader (clojure.java.io/reader file)]
    (vec (line-seq reader))))

(defn to-byte-array [n++-binary-format]
  (byte-array (map byte n++-binary-format)))

(defn to-byte-string [n++-binary-format]
  (ByteString/copyFrom
    (to-byte-array n++-binary-format)))