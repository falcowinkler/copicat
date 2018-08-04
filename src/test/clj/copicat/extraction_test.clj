(ns copicat.extraction-test
  (:require [clojure.test :refer :all]
            [copicat.extraction :refer :all]
            [clojure.java.io :refer :all]
            [copicat.formats.nplusplus :refer :all]
            [clojure.java.io :as io]))

(def test-file-path "src/test/resources/sample_data.txt")
(def test-string (slurp "src/test/resources/sample_data.txt"))

(deftest test-extract-tile-data
  (testing "Given a line of level data, test if tile data is extracted correctly"
    (is (= "0809" (subs (extract-tile-data test-string :text-n++) 0 4)))))

(deftest test-extract-level-name
  (testing "Level name is extracted from textual level format"
    (is (= "flateau" (extract-level-name test-string)))))

(deftest test-split-tile-data
  (testing "Split the test data in chunks"
    (is (= ["01" "01" "10"] (split-tile-data "010110")))))

(deftest test-get-tile-data-from-file
  (testing "binary file is extracted"
    (is (= [0x08 0x09 0x07 0x06]
           (subvec (get-tile-data-from-binary-file "resources/test") 0 4)))))

(deftest string-tile-data-to-binary-test
  (testing "the conversion from text to binary works"
    (is (= [0x08 0x09 0x07 0x06]
           (subvec
             (string-format-to-binary test-string :text-n++)
             0 4)))
    (is (= 966
            (count
              (string-format-to-binary test-string :text-n++))))))

(deftest get-name-data-pairs-test
  (testing "if name-data-pairs are extracted"
    (is (= [["output-folder/flateau" (string-format-to-binary test-string :text-n++)]]
           (get-name-data-pairs test-file-path "output-folder" :text-n++)))))
