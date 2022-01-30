(ns advent-2021.day1-test
  (:require [clojure.test :refer :all]
            [advent-2021.day1 :as day1]))

(def test-data
  (list 199
        200
        208
        210
        200
        207
        240
        269
        260
        263))

(deftest solves-p1
  (testing
   (is (= 7 (day1/solve-p1 test-data)))))

(deftest solves-p2
  (testing
   (is (= 5 (day1/solve-p2 test-data)))))
