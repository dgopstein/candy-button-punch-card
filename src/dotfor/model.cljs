(ns dotfor.model)

; http://stackoverflow.com/questions/11670941/generate-character-sequence-from-a-to-z-in-clojure
; mine - http://stackoverflow.com/questions/37775349/ordinal-int-ascii-value-of-character
(defn char-range [start end]
  (map char (range (.charCodeAt start) (inc (.charCodeAt end)))))


(def gbcd-chars
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
 
(defn build-encoder [encoding]
  (zipmap encoding (range)))

(def gbcd-encoder (build-encoder gbcd-chars))

; https://clojuredocs.org/clojure.core/bit-shift-right
(defn bits [n s]
  (reverse
    (take s
      (map
        (fn [i] (bit-and 0x01 i))
          (iterate
            (fn [i] (bit-shift-right i 1))
          n)))))

(defn int-to-6-dots [i]
  (map #(= 1 %) (bits i 6)))

(defn char-to-6-dots [encode c]
  ;(prn "encode " (encode c))
  (int-to-6-dots (encode c)))

(defn str-to-6-dots [encode s]
  (map #(char-to-6-dots encode %) (seq s)))

