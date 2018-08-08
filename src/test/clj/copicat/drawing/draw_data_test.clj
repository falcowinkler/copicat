(ns copicat.drawing.draw_data_test
  (:require [clojure.test :refer :all]
            [clojure.java.io :refer :all]
            [copicat.extraction-util :refer :all]
            [copicat.drawing.draw-data :refer :all]))

(deftest test-board-with
  (testing "width is correctly calculated"
    (is (= 31 (board-with 713)))
    (is (= 42 (board-with 966)))))

(deftest line-by-line-tile-iteration-test
  (testing "If tile iteration works"
    (with-redefs [board-with (constantly 3) board-height 2]
      (is (= [[0 0] [1 0] [2 0] [0 1] [1 1] [2 1]]
             (line-by-line-tile-iteration 713))))))

(deftest test-index-for-coordinate
  (testing "index for coordinate is correct"
    (is (= 0 (index-for-coordinate 0 0 713)))
    (is (= 30 (index-for-coordinate 30 0 713)))
    (is (= 32 (index-for-coordinate 1 1 713)))))