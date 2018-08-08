(ns copicat.source
  (:require
    [copicat.io-util :as io]
    [copicat.extraction-util :as e]
    [clojure.java.io :refer :all]
    [copicat.formats.n :as n]
    [copicat.formats.nplusplus :as n++]
    [copicat.formats.protobuf :as pb]))

(defmulti slurp-tile-data (fn [args] (:input-format args)))

(defmethod slurp-tile-data :text-n [{:keys [input-path]}]
  (for [file (io/get-file-or-files input-path)
        line (io/get-lines-from-file file)]
    {:level-name (e/extract-level-name line)
     :tile-data  (n/to-binary line)}))

(defmethod slurp-tile-data :binary-n++ [{:keys [input-path]}]
  (for [file (io/get-file-or-files input-path)]
    {:level-name (.getName file)
     :tile-data  (n++/get-tile-data-from-binary-file file)}))

(defmethod slurp-tile-data :protobuf [{:keys [input-path]}]
  (for [file (io/get-file-or-files input-path)]
    {:level-name (.getName file)
     :tile-data (pb/de-serialize-from-file file)}))