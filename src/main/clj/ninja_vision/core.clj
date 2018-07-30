(ns ninja-vision.core
  (:gen-class)
  (:require
    [quil.core :as q]
    [ninja-vision.drawing :refer :all]
    [ninja-vision.extraction :refer :all]
    [clojure.java.io :as io]
    [clojure.tools.cli :as cli]))


(def cli-options
  [["-o" "--output file-or-folder-path" nil "Output file or folder path"
    :id :output-path
    :validate [#(or (.isDirectory (io/file %)) (.isFile (io/file %))) "Specified folder/file not found"]]
   ["-i" "--input file-or-folder-path" "Input file or folder path"
      :id :input-path
      :validate [#(or (.isDirectory (io/file %)) (.isFile (io/file %))) "Specified folder/file not found"]]
   ["--input-format binary|text|ml" nil "Input format"
    :id :input-format
    :default :binary
    :validate [#(keyword? %) "This output format is not available"]]
   ["--output-format binary|text|ml|image" nil "Output format"
    :id :output-format
    :default :image
    :validate [#(keyword? %) "This output format is not available"]]])

(defn -main
  [& args]
  (let [{:keys [input-path output-path input-format output-format]}
        (:options (cli/parse-opts args cli-options))]
    (q/sketch
      :size [1260 690]
      :draw (partial draw (get-tile-data-from-byte-array "test")))))

