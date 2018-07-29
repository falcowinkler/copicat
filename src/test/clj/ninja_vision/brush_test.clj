(ns ninja-vision.brush-test
  (:require [clojure.test :refer :all]
            [ninja-vision.brush :refer :all]
            [clojure.java.io :refer :all]
            [ninja-vision.extraction :refer :all]
            [quil.core :as q]
            [ninja-vision.draw-data :refer :all]))


(deftest test-paint
  (testing "if paints correctly"
    (with-redefs [draw  draw]
      (let [testdata (slurp (resource "sample_data.txt"))
            tiledata (extract-tile-data testdata)]
        (q/defsketch trigonometry
                     :size [300 300]
                     :draw (partial draw tiledata))))))




(deftest index-for-coordinate-test
  (testing "if correct index is returned"
    (with-redefs [board-width 5]
      (is (= 5 (index-for-coordinate 0 1)))
      (is (= 2 (index-for-coordinate 2 0)))
      (is (= 0 (index-for-coordinate 0 0)))
      (is (= 11 (index-for-coordinate 1 2))))))


(deftest test-get-lines
  (testing "if lines are fetched correctly"
    (with-redefs
      [data-to-draw-data {"01" {:lines "test"}}]
      (is (= "test" (get-lines ["10" "10" "01" "10"] 2))))))
