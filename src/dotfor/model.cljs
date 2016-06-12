(ns dotfor.model)

; http://stackoverflow.com/questions/11670941/generate-character-sequence-from-a-to-z-in-clojure
(defn char-range [start end]
  (map char (range (int start) (inc (int end)))))


(def bcd-chars
  (flatten [
    (char-range 48 57)
    [\[ \# \@ \: \> \? \  ]
    (char-range 65 73)
    [\& \. \] \( \< \\ \^]
    (char-range 74 82)
    [\- \$ \* \) \; \' \+ \/]
    (char-range 83 90)
    [\_ \, \% \= \" \!]
    ]))
