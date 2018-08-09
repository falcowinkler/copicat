(ns copicat.formats.n-test
  (:require [clojure.test :refer :all]
            [copicat.formats.n :as n]))

(def test-string (slurp "src/test/resources/n-example-file.txt"))
(def generated-test-string (slurp "src/test/resources/generated-n-example-file.txt"))

(deftest test-extract-level-data
  (testing "Leveldata is fetched with regex"
    (is (= "00000006969696901000001"
           (subs (n/extract-tile-data test-string) 0 23)))))

(deftest test-to-binary
  (testing "binary is correctly converted"
    (let [result (n/to-binary test-string)]
      (is (= (* 31 23) (count result))))))

(deftest level-string-from-binary-test
  (testing "level-string generates correctly"
    (is (= generated-test-string
           (n/level-string-from-binary
             (n/to-binary test-string) "Drone_BuildingDash")))))