(ns copicat.formats.tfrecord
  (:require [clojure.tools.logging :as log])
  (:import (copicat.proto BytesList Example Feature Features)
           (com.google.protobuf ByteString)
           (java.io FileOutputStream DataOutputStream)
           (copicat.tfrecord TFRecordWriter)))

(defn to-byte-string [n++-binary-format]
  (ByteString/copyFrom
    (byte-array (map byte n++-binary-format))))

(defn serialize-to-example-format [n++-binary-format]
  (let [bytes-list-builder (BytesList/newBuilder)
        feature-builder (Feature/newBuilder)
        features-builder (Features/newBuilder)
        example-builder (Example/newBuilder)]
    (.addValue bytes-list-builder (to-byte-string n++-binary-format))
    (.setBytesList feature-builder bytes-list-builder)
    (.putFeature features-builder "raw_tile_data" (.build feature-builder))
    (.setFeatures example-builder features-builder)
    (-> example-builder .build .toByteArray)))

(defn create-dataset [name-data-pairs]
  (let [out (new DataOutputStream
                 (new FileOutputStream "n_maps.tfrecord"))
        tfrecord-writer (new TFRecordWriter out)]
    (doseq [[name data] name-data-pairs]
      (log/info "Serializing n-level " name " into .tfrecord dataset")
      (.write tfrecord-writer (serialize-to-example-format data)))
    (.close out)))

