(ns copicat.formats.tfrecord-tests
  (:require [clojure.test :refer :all]
            [copicat.formats.tfrecord :as tf]
            [copicat.extraction :as ex]))


(def test-tile-data
  (ex/get-tile-data-from-binary-file "resources/test"))

