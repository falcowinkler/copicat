(ns ninja-vision.extraction-test
  (:require [clojure.test :refer :all]
            [ninja-vision.extraction :refer :all]
            [clojure.java.io :refer :all]
            [clojure.java.io :as io]))


(deftest test-extract-tile-data
  (testing "Given a line of level data, test if tile data is extracted correctly"
    (let [test-data (slurp (resource "sample_data.txt"))]
      (is (= "0809" (subs (extract-tile-data test-data) 0 4))))))

(deftest test-split-tile-data
  (testing "Split the test data in chunks"
    (is (= ["01" "01" "10"] (split-tile-data "010110")))))

(deftest test-get-tile-data-from-file
  (testing "if binary file is extracted"
    (is (= [0x08 0x09 0x07 0x06]
           (subvec (tile-data-from (io/resource "test") :binary) 0 4)))))

