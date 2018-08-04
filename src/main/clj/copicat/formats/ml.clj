(ns copicat.formats.ml
  (:import (copicat.proto TileData)
           (com.google.protobuf ByteString)))
(require '[protobuf.core :as protobuf])

(defn to-protobuf
  [n++-binary-format]
  (protobuf/create
    TileData {:raw_data
              (ByteString/copyFrom
                (byte-array (map byte n++-binary-format)))}))

(defn read-protobuf-file [file]
  (protobuf/read
    (protobuf/create
      TileData {:raw_data
                (ByteString/copyFrom (byte-array [(byte 0)]))}) file))
