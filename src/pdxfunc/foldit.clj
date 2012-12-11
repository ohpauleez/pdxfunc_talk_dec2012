(ns pdxfunc.foldit
  (require [clojure.core.reducers :as r]))

(comment
  r/fold
  )

;; let's take a look at some Clojure math
(comment
  (+)
  (inc 1) ;; can't be a c-function
  (*))

;; Whoa!
;; So plus/+ carries its own identity function - it has its own seed
;; As does multiply/*
;;
;; but inc requires an argument.
;; In order to use it in a reduction (like above), we'd need a function to seed it

;; So that combining function is a MONOID!!!!
;; and participation in the parallelization is from a protocol - ie: How do YOU fold yourself?
;;
;; This is defined for all of the built-in data structures

(comment
  (require '[clojure.core.reducers :as r])
  (def v (into [] (range 10000000)))
  (time (reduce + (map inc (filter even? v))))
  (time (reduce + (r/map inc (r/filter even? v))))
  (time (r/fold + (r/map inc (r/filter even? v))))
)

