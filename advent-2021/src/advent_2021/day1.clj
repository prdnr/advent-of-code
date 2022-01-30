(ns advent-2021.day1
  (:require [clojure.string :as str]))

(defn- parse
  [input]
  (map #(Integer/parseInt %) (str/split-lines input)))

(defn solve-p1
  [input]
  (count (filter #(apply < %) (partition 2 1 input))))

(defn part1
  [input]
  (solve-p1 (parse input)))

(defn solve-p2
  [input]
  (count (filter #(apply < %) (partition 2 1 (map #(apply + %) (partition 3 1 input))))))

(defn part2
  [input]
  (solve-p2 (parse input)))
