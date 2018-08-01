(ns ninja-vision.extraction-test
  (:require [clojure.test :refer :all]
            [ninja-vision.extraction :refer :all]
            [clojure.java.io :refer :all]
            [clojure.java.io :as io]))

(def test-string (slurp (resource "sample_data.txt")))

(deftest test-extract-tile-data
  (testing "Given a line of level data, test if tile data is extracted correctly"
    (is (= "0809" (subs (extract-tile-data test-string) 0 4)))))

(deftest test-extract-level-name
  (testing "Level name is extracted from textual level format"
    (is (= "flateau" (extract-level-name test-string)))))

(deftest test-split-tile-data
  (testing "Split the test data in chunks"
    (is (= ["01" "01" "10"] (split-tile-data "010110")))))

(deftest test-get-tile-data-from-file
  (testing "binary file is extracted"
    (is (= [0x08 0x09 0x07 0x06]
           (subvec (get-tile-data-from-binary-file (io/resource "test")) 0 4)))))

(deftest string-tile-data-to-binary-test
  (testing "the conversion from text to binary works"
    (is (= [0x08 0x09 0x07 0x06]
           (subvec
             (string-tile-data-to-binary
               (extract-tile-data test-string))
             0 4)))
    (is (= 966
            (count
              (string-tile-data-to-binary
                (extract-tile-data test-string)))))))
