(ns advent-2021.day2
  (:require [clojure.string :as str]))

(defn parse-line
  [input]
  (let [words (str/split input #" ")
        num (Integer/parseInt (second words))
        key (keyword first words)]
    (list key num)))

(defn- parse
  [input]
  (map parse-line (str/split-lines input)))

(defn solve-p1
  [input]
  (reduce (fn [x] x) #{:x 0 :y 0} input))

(defn part1
  [input]
  (solve-p1 (parse input)))

(defn solve-p2
  [input]
  input)

(defn part2
  [input]
  (solve-p2 (parse input)))
