(ns copicat.core
  (:gen-class)
  (:require
    [copicat.drawing.painter :refer :all]
    [copicat.extraction-util :refer :all]
    [copicat.io-util :refer :all]
    [clojure.java.io :as io]
    [clojure.tools.cli :as cli]
    [clojure.tools.logging :as log]
    [copicat.source :as source]
    [copicat.sink :as sink]))



(defn exists-in [col item]
  (some #(= % item) col))


(def cli-options
  [["-o" "--output file-or-folder-path" nil "Output file or folder path"
    :id :output-path]
   ["-i" "--input file-or-folder-path" "Input file or folder path"
    :id :input-path
    :validate [#(or (.isDirectory (io/file %)) (.isFile (io/file %)))
               "Specified folder/file not found"]]
   [nil "--input-format binary|text-n++|text-n|proto|tfrecord" "Input format"
    :id :input-format
    :default :binary
    :validate [#(exists-in [:binary :text-n++ :text-n :protobuf :tfrecord] %)
               (str "Input format not supported")]
    :parse-fn #(keyword %)]
   [nil "--output-format binary|text-n|proto|tfrecord|image" "Output format"
    :id :output-format
    :default :image
    :validate [#(exists-in [:binary :text-n :protobuf :tfrecord :image] %)
               (str "Output format not supported")]
    :parse-fn #(keyword %)]])

(defn -main
  [& args]
  (let [opts (cli/parse-opts args cli-options)]
    (if (not (nil? (:errors opts)))
      (do
        (log/info "Could not parse args: " (:errors opts))
        (log/info "Usage: " (:summary opts)))
      (sink/spit-tile-data
        (assoc (:options opts) :data-list
                    (source/slurp-tile-data (:options opts)))))))


