(ns pdxfunc.sll)

;;(comment
;;  (require '[clojure.inspector :as inspector])
;;
;;  ;; The ns browser has the inspector wrapped in it
;;  (use 'clj-ns-browser.sdoc)
;;  (sdoc)
;;  )

;; Here is a singly-linked list of four elements
;; There is absolutely nothing special about it
(def l '(:a :b :c :d))
(comment
  (type l)
  (count l)
  (supers (class l)))

(def ll (conj l :e))
(comment
  (= l ll)
  (= l (next ll))
  (identical? l (next ll)))

;; AHA!  So we can visualize `l` and `ll` like:
;;     l        :a - :b -:c - :d
;;     ll    e:/
;;
;; Does this hold if we keep at this?

(def rl (next l))
(def rll (conj rl :z))
(def llrll (conj rl ll))
(comment
  rl
  llrll
  (= (-> llrll first next next) (next llrll))
  (identical? (-> llrll nfirst next) (next llrll)))

;; So we're seeing that sharing is happening!  AWESOME!

