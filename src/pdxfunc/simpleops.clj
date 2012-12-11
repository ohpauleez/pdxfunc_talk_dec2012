(ns pdxfunc.simpleops)

;; This is the canonical definition of `map`
(defn simple-map [f coll]
  (cons (f (first coll)) (simple-map f (rest coll))))

;; But what is this doing?
;;  * Recursion
;;  * Order (assumed and maintained)
;;  * Laziness (could also promise - most often does)
;;  * Consumes list
;;  * Builds list

;; But is this really what map is doing?  NO!

;; We could get around some of these if we asked the collection,
;; "How do I map on YOU!"
;;
;; That is, if the collection could drive.

;; Let's take a look at Clojure's reduce
(comment
  reduce) ;; use [d in foreplay to look at the source here

;; So what's going on here?
;; * Ignorant of collection structure
;; * Can build anything - this a pattern in fp
;; * Not lazy
;; * But it is still ordered: left fold with a seed with a binary function

;; BUT THERE'S A PROBLEM!!!!
;; `map` and `filter` don't depend on order - so we should define them as such
;; And we can get there if we make them collection ignorant and build them on `reduce`.

