(ns dotfor.core
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]
            [dotfor.model :as model]
            [clojure.string :as string]
            ))

(defn setup []
  (q/frame-rate 1)

  (q/color-mode :hsb)
  ; setup function returns initial state. Empty hash
  {})

(defn update-state [state] state)

(defn draw-state [state]
  ; Clear the sketch by filling it with light-grey color.
  (q/background 240)
  ; Set circle color.
  (q/fill 255 255 0)
  (q/text-size 18)
  (q/text (clojure.string/join (take 32 model/bcd-chars)) 5 100)
  (q/text (clojure.string/join (drop 32 model/bcd-chars)) 5 200)
  (q/text (count model/bcd-chars) 5 300)
  (q/text (str (int 65) ) 5 400)
  ; Calculate x and y coordinates of the circle.
  ;(let [angle (:angle state)
  ;      x (* 150 (q/cos angle))
  ;      y (* 150 (q/sin angle))]
  ;  ; Move origin point to the center of the sketch.
  ;  (q/with-translation [(/ (q/width) 2)
  ;                       (/ (q/height) 2)]
  ;    ; Draw the circle.
  ;    (q/ellipse x y 100 100))))
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
