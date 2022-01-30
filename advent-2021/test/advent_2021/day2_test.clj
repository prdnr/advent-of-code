(ns advent-2021.day1-test
  (:require [clojure.test :refer :all]
            [advent-2021.day2 :as day2]))

(def test-data
  (list :forward 5
        :down 5
        :forward 8
        :up 3
        :down 8
        :forward 2))

(deftest parseing-input-line
  (test
   (is (= (list :forward 2) (day2/parse-line "forward 2")))))

(deftest solves-p1
  (testing
   (is (= 150 (day2/solve-p1 test-data)))))

(deftest solves-p2
  (testing
   (is (= 900 (day2/solve-p2 test-data)))))
