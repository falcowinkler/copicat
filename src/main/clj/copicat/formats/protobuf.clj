(ns copicat.formats.protobuf
  (:import (copicat.proto DataProtos$TileData)
           (java.io FileOutputStream FileInputStream))
  (:require [clojure.tools.logging :as log]
            [clojure.string :as string]
            [copicat.io-util :as io-util]))

(defn serialize-to-file [path data]
  (let [builder (DataProtos$TileData/newBuilder)]
    (.setRawData builder (io-util/to-byte-string data))
    (.writeTo (.build builder) (new FileOutputStream (str path ".pb")))))

(defn de-serialize-from-file [file-name]
  (vec (.toByteArray
         (.getRawData
           (DataProtos$TileData/parseFrom
             (new FileInputStream file-name))))))