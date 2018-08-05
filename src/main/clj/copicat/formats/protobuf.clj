(ns copicat.formats.protobuf
  (:import (copicat.proto DataProtos$TileData)
           (com.google.protobuf ByteString)
           (java.io FileOutputStream FileInputStream))
  (:require [clojure.tools.logging :as log]
            [clojure.string :as string]))

(defn to-byte-string [n++-binary-format]
  (ByteString/copyFrom
    (byte-array (map byte n++-binary-format))))

(defn serialize-to-file [name data]
  (let [builder (DataProtos$TileData/newBuilder)]
    (.setRawData builder (to-byte-string data))
    (.writeTo (.build builder) (new FileOutputStream name))))

(defn de-serialize-from-file [file-name]
  (vec (.toByteArray
         (.getRawData
           (DataProtos$TileData/parseFrom
             (new FileInputStream file-name))))))

(defn create-dataset [name-data-pairs]
  (doseq [[name data] name-data-pairs]
    (if (not (string/blank? name))
      (do
        (serialize-to-file (str "n_" name ".pb") data)
        (log/info "Saved protocol buffer " name ".pb")))))