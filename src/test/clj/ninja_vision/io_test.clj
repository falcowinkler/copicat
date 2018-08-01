(ns ninja-vision.io-test
  (:require [clojure.test :refer :all]
            [ninja-vision.io :refer :all]
            [clojure.java.io :as io]))

(deftest get-file-or-files-test
  (testing "If get file or files works"
    (is (= 5 (count
               (filter #(not (= ".DS_Store" (.getName %)))
                       (get-file-or-files "src/test/resources/some-binaries")))))
    (is (= 1 (count (get-file-or-files "src/test/resources/test"))))))

(def bfile "test-binary-file")

(deftest test-slurp-bytes
  (testing "Slurping bytes"
    (if (.isFile (io/file bfile))
      (io/delete-file bfile))
    (with-open [w (io/output-stream bfile)] (.write w 0x23) (.write w 0x1a))
    (is (= [0x23 0x1a] (slurp-bytes bfile)))
    (io/delete-file bfile)))

(deftest test-get-lines-from-file
  (testing "parsing file line by line"
    (is (= ["reboot" "tut" "gut"
            (get-lines-from-file "src/test/resources/test-file.txt")]))))