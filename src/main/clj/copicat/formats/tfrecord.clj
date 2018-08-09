(ns copicat.formats.tfrecord
  (:require [copicat.io-util :as io-util])
  (:import (copicat.proto BytesList Example Feature Features)
           (java.io FileOutputStream DataOutputStream)
           (copicat.tfrecord TFRecordWriter)))

(defn serialize-to-example-format [n++-binary-format]
  (let [bytes-list-builder (BytesList/newBuilder)
        feature-builder (Feature/newBuilder)
        features-builder (Features/newBuilder)
        example-builder (Example/newBuilder)]
    (.addValue bytes-list-builder (io-util/to-byte-string n++-binary-format))
    (.setBytesList feature-builder bytes-list-builder)
    (.putFeature features-builder "raw_tile_data" (.build feature-builder))
    (.setFeatures example-builder features-builder)
    (-> example-builder .build .toByteArray)))

(defn write-to-tfrecord [serialized-data-list output-path]
  (let [out (new DataOutputStream
                 (new FileOutputStream output-path))
        tfrecord-writer (new TFRecordWriter out)]
    (doseq [serialized-example serialized-data-list]
      (.write tfrecord-writer serialized-example))
    (.close out)))