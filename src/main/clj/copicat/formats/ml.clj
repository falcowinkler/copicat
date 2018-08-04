(ns copicat.formats.ml
  (:import (copicat.proto DataProtos$TileData)
           (com.google.protobuf ByteString))
  (:require [protobuf.core :as protobuf]
            [clojure.tools.logging :as log]
            [clojure.java.io :as io]
            [clojure.string :as string]))

(defn to-protobuf
  [n++-binary-format]
  (protobuf/create
    DataProtos$TileData {:raw_data
                         (ByteString/copyFrom
                           (byte-array (map byte n++-binary-format)))}))

(defn read-protobuf-file [file]
  (protobuf/read
    (protobuf/create
      DataProtos$TileData {:raw_data
                           (ByteString/copyFrom (byte-array [(byte 0)]))}) file))

(defn create-dataset [name-data-pairs]
  (doseq [[name data] name-data-pairs]
    (if (not (string/blank? name))
      (do
        (with-open [out (io/output-stream (str name ".pb"))]
          (protobuf/write (to-protobuf data) out))
        (log/info "Saved protocol buffer " name)))))