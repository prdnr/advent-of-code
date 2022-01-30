(ns aoc2021.core
  (:require [clojure.string]))

(defn -main []
    (println (read-n-parse *in*)))

(defn read-n-parse [loc]
  (slurp loc))

(-main)
