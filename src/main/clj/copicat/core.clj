(ns copicat.core
  (:gen-class)
  (:require
    [copicat.drawing :refer :all]
    [copicat.extraction :refer :all]
    [copicat.io :refer :all]
    [clojure.java.io :as io]
    [clojure.tools.cli :as cli]
    [clojure.tools.logging :as log]
    [copicat.formats.protobuf :as proto]))

(defn exists-in [col item]
  (some #(= % item) col))


(def cli-options
  [["-o" "--output file-or-folder-path" nil "Output file or folder path"
    :id :output-path
    :validate [#(or (.isDirectory (io/file %)) (.isFile (io/file %)))
               "Specified folder/file not found"]]
   ["-i" "--input file-or-folder-path" "Input file or folder path"
    :id :input-path
    :validate [#(or (.isDirectory (io/file %)) (.isFile (io/file %)))
               "Specified folder/file not found"]]
   [nil "--input-format binary|text-n++|text-n|proto" "Input format"
    :id :input-format
    :default :binary
    :validate [#(exists-in [:binary :text-n++ :text-n :proto] %)
               (str "Input format not supported")]
    :parse-fn #(keyword %)]
   [nil "--output-format binary|text-n|proto|image" "Output format"
    :id :output-format
    :default :image
    :validate [#(exists-in [:binary :text-n :proto :image] %)
               (str "Output format not supported")]
    :parse-fn #(keyword %)]])

(defn -main
  [& args]
  (let [opts (cli/parse-opts args cli-options)
        {:keys [input-path output-path input-format output-format]}
        (:options opts)]
    (if (not (nil? (:errors opts)))
      (do
        (log/info "Could not parse args: " (:errors opts))
        (log/info "Usage: " (:summary opts)))
      (let [name-data-pairs (get-name-data-pairs input-path output-path input-format)]
        (case output-format
          :image
          (save-images name-data-pairs)
          :proto
          (proto/create-dataset name-data-pairs))))))


