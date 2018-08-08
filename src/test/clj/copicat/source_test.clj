(ns copicat.source-test
  (:require [clojure.test :refer :all]
            [copicat.source :as s]))

(def test-file-path "src/test/resources/n-example-file.txt")

(def w 31)

(deftest test-n-text-format-source
  (testing "Data source from n format works"
    (let [result (first (s/slurp-tile-data {:input-format :text-n :input-path test-file-path}))]
      (is (= "Drone_BuildingDash" (:level-name result)))
      (is (= (repeat w 0) (subvec (:tile-data result) 0 w)))
      (is (= [0 8 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 1 1 0 1 1]
             (subvec (:tile-data result) w (* 2 w)))))))