(ns copicat.extraction-util
  (:require
    [copicat.io-util :refer :all]
    [clojure.string :as string]))

(def level-name-regex #"(?<=\$)(.*?)(?=\#)")

(defn extract-tile-data [level-data regex]
  (let [matcher (re-matcher regex level-data)]
    (if (not (nil? (re-find matcher)))
      (second (re-groups matcher)))))

(defn cleanup_level_name [level_name]
  (let [clean-result (string/replace (string/trim level_name) "/" "-")]
    (if (> (count clean-result) 100) (subs clean-result 0 100) clean-result)))

(defn extract-level-name [level-data]
  (if-let [result (re-find level-name-regex level-data)]
    (cleanup_level_name (first result))))