(ns adg.core
  (:gen-class)
  (:require [clojure.spec.alpha :as s]
            [clj-time.format]
            [clj-time.core :as t]
            [clj-time.coerce]
            [clj-time.local :as l]
            [clojurewerkz.elastisch.rest  :as esr]
            [clojurewerkz.elastisch.rest.index :as esi]
            [clojurewerkz.elastisch.rest.document :as esd]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


(defn -main
  [& args]
  (print "Hi there"))


(defn index-es-doc
  [& args]
  (let [conn (esr/connect "http://192.168.0.30:9200" {:content-type :json})]
    (esd/create conn "myapp" "tweet"
                {:username "Happyjoe"
                 :text "My first document submitted to ElasticSearch!"
                 :timestamp (->>(l/local-now) .toString)})))

(defn post-docs
  [ndocs]
  (dotimes [n ndocs]
    (do (Thread/sleep (rand-int 10))
        (index-es-doc))))
