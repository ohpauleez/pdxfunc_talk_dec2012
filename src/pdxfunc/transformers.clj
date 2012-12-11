(ns pdxfunc.transformers)

;; Here are the canonical transformers
(defn mapping [f]
  (fn [f1]
    (fn [result input]
      (f1 result (f input)))))

;; What's happening here?
;; (put reduce in your mind)
;; We need something that can be a reducing function, something you could pass to reduce
;; A binary function that takes an accumulator and something you're trying to reduce
;;
;; `result` is an accumlator, something you're building up
;; We need a function that can be passed to reduce,
;; and we need to package that up as a "reducing function"
;;
;; What we end with is EXACTLY what it means to map

;; But this totally sucks to use
(reduce ((mapping inc) +) 0 [1 2 3 4])
(reduce + (map inc [1 2 3 4]))

;; this can be scrubbed away with protocols.
;; And you end up with something like
(comment
  (defn rmap [f coll]
    (reducer coll (mapping f)))
  
  (reduce + 0 (rmap inc [1 2 3 4]))
)

;; But reduce is still sequential :(
;; We want to avoid that!

