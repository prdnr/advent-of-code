(ns advent-2021.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [clojure.java.io :as io]
            [advent-2021.day1 :as day1]
            [advent-2021.day2 :as day2])
  (:gen-class))

(def cli-options
  [["-d" "--day DAY" "Day to solve"
    :default 1
    :parse-fn #(Integer/parseInt %)
    :validate [#(< 0 % 31) "Must be a day in December."]]])

(defn -main [& args]
  (let [opts (parse-opts args cli-options)
        errs (:errors opts)
        day (:day (:options opts))]
    (if (seq errs)
      (println errs)
      (case day
        1 (do
            (print "Day 1 Part 1 Solution: ")
            (println (day1/part1 (slurp (io/resource "day1.input"))))
            (print "Day 1 Part 2 Solution: ")
            (println (day1/part2 (slurp (io/resource "day1.input")))))
        2 (do
            (print "Day 2 Part 1 Solution: ")
            (println (day2/part1 (slurp (io/resource "day2.input"))))
            (print "Day 2 Part 2 Solution: ")
            (println (day1/part2 (slurp (io/resource "day2.input")))))

        (println opts)))))
