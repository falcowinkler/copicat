(ns copicat.formats.ml_tests
  (:require [clojure.test :refer :all]
            [copicat.formats.ml :as ml]
            [copicat.extraction :as ex]))

(def test-tile-data
  (ex/get-tile-data-from-binary-file "resources/test"))

(deftest test-format-conversion
  (testing "if protobuf conversion works"
    (ml/serialize-to-file "test.pb" test-tile-data)
    (is (= test-tile-data (ml/de-serialize-from-file "test.pb")))))
