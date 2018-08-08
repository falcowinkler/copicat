(ns copicat.formats.n++-test
  (:require [clojure.test :refer :all] [copicat.formats.nplusplus :refer :all]))


(deftest test-get-tile-data-from-file
  (testing "binary file is extracted"
    (is (= [0x08 0x09 0x07 0x06]
           (subvec (get-tile-data-from-binary-file "resources/test") 0 4)))))