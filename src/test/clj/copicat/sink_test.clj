(ns copicat.sink-test
  (:require
    [clojure.test :refer :all]
    [copicat.sink :as sink]
    [copicat.formats.nplusplus :as n++]
    [copicat.formats.protobuf :as pb]
    [clojure.java.io :as io]))

(def test-data (n++/get-tile-data-from-binary-file "src/test/resources/test-level"))
(def test-output-folder "test-output")

(defn create-test-directory [] (.mkdir (java.io.File. "test-output")))
(defn remove-test-directory []
  (doseq [f (reverse (file-seq (clojure.java.io/file test-output-folder)))]
    (clojure.java.io/delete-file f)))

(defn sink-test-fixture [f]
  (create-test-directory)
  (f)
  (remove-test-directory))

(use-fixtures :once sink-test-fixture)

(deftest test-protobuf-sink
  (testing "protobuf sink works"
    (sink/spit-tile-data
      {:output-format :proto
       :output-path   test-output-folder
       :data-list     [{:tile-data test-data :level-name "test"}]})
    (is (= test-data (pb/de-serialize-from-file (str test-output-folder "/test.pb"))))))

(deftest test-tfrecord-sink
  (testing "tfrecord file is generated"
    (sink/spit-tile-data
      {:output-format :tfrecord
       :output-path   (str test-output-folder "/test.tfrecord")
       :data-list     [{:tile-data test-data}]})
    (is (true? (.exists (io/as-file (str test-output-folder "/test.tfrecord")))))))