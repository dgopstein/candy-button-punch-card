(ns dotfor.model)

; http://stackoverflow.com/questions/11670941/generate-character-sequence-from-a-to-z-in-clojure
; mine - http://stackoverflow.com/questions/37775349/ordinal-int-ascii-value-of-character
(defn char-range [start end]
  (map char (range (.charCodeAt start) (inc (.charCodeAt end)))))


(def bcd-chars
  (flatten [
    (char-range \0 \9)
    [\[ \# \@ \: \> \? \  ]
    (char-range \A \I)
    [\& \. \] \( \< \\ \^]
    (char-range \J \R)
    [\- \$ \* \) \; \' \+ \/]
    (char-range \S \Z)
    [\_ \, \% \= \" \!]
    ]))
 
 (def ord-a (int \a))
