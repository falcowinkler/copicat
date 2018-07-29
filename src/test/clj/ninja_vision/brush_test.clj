(ns ninja-vision.brush-test
  (:require [clojure.test :refer :all]
            [clojure.java.io :refer :all]
            [ninja-vision.extraction :refer :all]
            [ninja-vision.draw-data :refer :all]))

(deftest index-for-coordinate-test
  (testing "if correct index is returned"
    (with-redefs [board-width 5]
      (is (= 5 (index-for-coordinate 0 1)))
      (is (= 2 (index-for-coordinate 2 0)))
      (is (= 0 (index-for-coordinate 0 0)))
      (is (= 11 (index-for-coordinate 1 2))))))

(deftest line-by-line-tile-iteration-test
  (testing "If tile iteration works"
    (is (= [[0 0] [1 0] [2 0][0 1] [1 1] [2 1]]))))

