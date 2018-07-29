(ns ninja-vision.extraction)

(def tile-data-regex #"\$[a-z]+#00000000([0-9].{1932})")

(defn extract-tile-data [level-data]
  (let [matcher (re-matcher tile-data-regex level-data)]
    (re-find matcher)
    (second (re-groups matcher))))

(defn split-tile-data [tile-data]
  (map (partial apply str) (partition 2 tile-data)))

(defn slurp-bytes
  [x]
  (with-open [out (java.io.ByteArrayOutputStream.)]
    (clojure.java.io/copy (java.lang.ClassLoader/getSystemResourceAsStream x) out)
    (.toByteArray out)))

(defn get-tile-data-from-byte-array [file-name]
  (subvec (vec (slurp-bytes file-name)) 0xB8 0x47E))