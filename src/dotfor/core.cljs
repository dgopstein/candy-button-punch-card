(ns dotfor.core
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]
            [dotfor.model :as model]
            [clojure.string :as string]
;            [clojure.browser.repl :as repl]
            ))

;(defonce conn
;  (repl/connect "http://localhost:9000/repl")) 


; https://gist.github.com/AlexBaranosky/4134522
;(defmacro doseq-indexed [index-sym [item-sym coll] & body]
;  `(doseq [[~index-sym ~item-sym] (map list (range) ~coll)]
;       ~@body))

; http://blog.klipse.tech/clojure/2016/05/09/macro-tutorial-4.html
;(defmacro doseq-indexed [index-sym [item-sym coll] & body]
;  `(doseq [[~item-sym ~index-sym]
;             (map vector ~coll (range))]
;                  ~@body))

; https://crossclj.info/fun/clojure.core.matrix.utils/doseq-indexed.html
(defmacro doseq-indexed
 "loops over a set of values, binding index-sym to the 0-based index of each value"
 ([[val-sym values index-sym] & code]
  `(loop [vals# (seq ~values)
    ~index-sym (long 0)]
    (if vals#
     (let [~val-sym (first vals#)]
      ~@code
      (recur (next vals#) (inc ~index-sym)))
     nil))))

(defn setup []
  (enable-console-print!)

  (q/frame-rate 1)

  (q/color-mode :hsb)
  ; setup function returns initial state. Empty hash
  {})

(defn update-state [state] state)

(defn str-to-bits [s]
  (model/str-to-6-dots model/gbcd-encoder s))

(defn str-to-dots [s]
    (doseq [[bits iy] (map vector (str-to-bits s) (range))
            [b ix] (map vector bits (range)) ]
      (if b
        (let [x (+ 50 (* 40 (mod ix 6)))
              y (+ 30 (* 40 iy))]
              (prn "ix iy (" ix iy)
              (prn "x y (" x y)
        (q/ellipse x y 20 20))))
  )
  

(defn draw-state [state]
  ; Clear the sketch by filling it with light-grey color.
  (q/background 240)
  ; Set circle color.
  (q/fill 255 255 0)
  (q/text-size 18)

  (str-to-dots "TEST STRING")
  ;(prn (zipmap model/gbcd-chars (range)))
  ;(q/text (clojure.string/join (take 32 model/gbcd-chars)) 5 100)
  ;(q/text (clojure.string/join (drop 32 model/gbcd-chars)) 5 200)
  ;(q/text (count model/gbcd-chars) 5 300)
  ;(q/text (str (int 65) ) 5 400)
  ;(prn (map #(= 1 %) (model/bits 31 6)))
  ;(prn (model/str-to-6-dots model/gbcd-encoder "TEST STRING"))

  )

(q/defsketch dotfor
  :host "dotfor"
  :size [500 500]
  ; setup function called only once, during sketch initialization.
  :setup setup
  ; update-state is called on each iteration before draw-state.
  :update update-state
  :draw draw-state
  ; This sketch uses functional-mode middleware.
  ; Check quil wiki for more info about middlewares and particularly
  ; fun-mode.
  :middleware [m/fun-mode])
