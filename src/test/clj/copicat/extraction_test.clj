(ns copicat.extraction-test
  (:require [clojure.test :refer :all]
            [copicat.extraction-util :refer :all]
            [clojure.java.io :refer :all]
            [copicat.formats.nplusplus :refer :all]
            [clojure.java.io :as io]))

(def test-string (slurp "src/test/resources/sample_data.txt"))

(deftest test-extract-tile-data
  (testing "Given a line of level data, test if tile data is extracted correctly"
    (is (= "0809" (subs (extract-tile-data test-string #"\$.+#0000000([0-9a-f].{1932})") 0 4)))))

(deftest test-extract-level-name
  (testing "Level name is extracted from textual level format"
    (is (= "flateau" (extract-level-name test-string)))))

(deftest test-split-tile-data
  (testing "Split the test data in chunks"
    (is (= ["01" "01" "10"] (split-tile-data "010110")))))

