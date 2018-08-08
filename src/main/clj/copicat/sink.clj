(ns copicat.sink
  (:require [copicat.formats.protobuf :as pb]
            [copicat.formats.tfrecord :as tf]
            [copicat.drawing.painter :as painter]
            [clojure.java.io :as io]
            [copicat.io-util :as io-util]
            [clojure.tools.logging :as log]))

(defn generate-path [level output-path]
  (str output-path "/" (:level-name level)))

(defmulti spit-tile-data (fn [args] (:output-format args)))

(defmethod spit-tile-data :text-n [{:keys [output-path data-list]}])

(defmethod spit-tile-data :tfrecord [{:keys [output-path data-list]}]
  (log/info "Generating .tfrecord file: " output-path)
  (tf/write-to-tfrecord
    (map tf/serialize-to-example-format
         (map :tile-data data-list)) output-path))

(defmethod spit-tile-data :proto [{:keys [output-path data-list]}]
  (doseq [level data-list]
    (pb/serialize-to-file
      (generate-path level output-path)
      (:tile-data level))))

(defmethod spit-tile-data :binary-n++ [{:keys [output-path data-list]}]
  (doseq [level data-list]
    (with-open [out (io/output-stream (generate-path level output-path))]
      (.write out (io-util/to-byte-array (:tile-data level))))))

(defmethod spit-tile-data :image [{:keys [output-path data-list]}]
  (painter/save-images data-list output-path))