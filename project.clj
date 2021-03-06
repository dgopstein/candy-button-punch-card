(defproject dotfor "0.1.1"
  :description "Program with Candy Dots"
  ; :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [quil "2.4.0"]
                 ;[rm-hull/monet "0.3.0"]
                 [org.clojure/clojurescript "1.8.34"]]

  :plugins [[lein-cljsbuild "1.1.3"]]
  :hooks [leiningen.cljsbuild]

  :cljsbuild
  {:builds [{:source-paths ["src"]
             :compiler
             {:output-to "js/main.js"
              :output-dir "out"
              :main "dotfor.core"
              :optimizations :none
              :pretty-print true}}]})
