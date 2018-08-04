(ns copicat.draw_data_test
  (:require [clojure.test :refer :all]
            [clojure.java.io :refer :all]
            [copicat.extraction :refer :all]
            [copicat.draw-data :refer :all]))

(deftest test-is-n++-format
  (testing "recognizing format by tile length"
    (is (true? (is-n++-format 966)))))

(deftest index-for-coordinate-test
  (testing "if correct index is returned"
    (with-redefs [board-with-n++ 5
                  board-height 5
                  is-n++-format (constantly true)]
      (is (= 5 (index-for-coordinate 0 1 966)))
      (is (= 2 (index-for-coordinate 2 0 966)))
      (is (= 0 (index-for-coordinate 0 0 966)))
      (is (= 11 (index-for-coordinate 1 2 966))))))

(deftest line-by-line-tile-iteration-test
  (testing "If tile iteration works"
    (is (= [[0 0] [1 0] [2 0] [0 1] [1 1] [2 1]]))))

