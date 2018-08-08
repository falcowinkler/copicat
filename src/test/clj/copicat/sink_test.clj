(ns copicat.sink-test
  (:require
    [clojure.test :refer :all]
    [copicat.sink :as sink]
    [copicat.formats.nplusplus :as n++]
    [copicat.formats.protobuf :as pb] [clojure.java.io :as io]))

(def test-data (n++/get-tile-data-from-binary-file "src/test/resources/test-level"))

(deftest test-protobuf-sink
  (testing "protobuf sink works"
    (sink/spit-tile-data
      {:output-format :proto
       :output-path   "out"
       :data-list     [{:tile-data test-data :level-name "test"}]})
    (is (= test-data (pb/de-serialize-from-file "out/test.pb")))
    (io/delete-file "out/test.pb")))

(deftest test-tfrecord-sink
  (testing "tfrecord file is generated"
    (sink/spit-tile-data
      {:output-format :tfrecord
       :output-path   "out/test.tfrecord"
       :data-list     [{:tile-data test-data}]})
    (is (true? (.exists (io/as-file "out/test.tfrecord"))))
    (io/delete-file "out/test.tfrecord")))