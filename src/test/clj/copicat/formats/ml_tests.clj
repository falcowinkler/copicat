(ns copicat.formats.ml_tests
  (:require [clojure.test :refer :all]
            [copicat.formats.ml :as ml]
            [clojure.java.io :as io]
            [copicat.extraction :as ex]
            [protobuf.core :as protobuf]))

(deftest test-format-conversion
  (testing "if tfrecord conversion works"
    (let [protobuf-tiledata
          (ml/to-protobuf
            (ex/get-tile-data-from-binary-file "resources/test"))
          test-f "testfile.protobuf"]
      (protobuf/write protobuf-tiledata test-f)
      (is
        (= protobuf-tiledata
           (ml/read-protobuf-file test-f)))
      (io/delete-file test-f))))