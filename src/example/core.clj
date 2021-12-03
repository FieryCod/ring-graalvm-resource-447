(ns example.core
  (:gen-class)
  (:require
   [ring.util.response :refer [resource-response]]
   [ring.adapter.jetty :as jetty]))

;; UNCOMMENT ME
;; (import '[java.net URL])
;; (require '[ring.util.response :as resp])
;; (defmethod resp/resource-data :resource
;;   [^URL url]
;;   (let [resource (.openConnection url)]
;;     {:content        (.getInputStream resource)
;;      :content-length (#'ring.util.response/connection-content-length resource)
;;      :last-modified  (#'ring.util.response/connection-last-modified resource)}))
;; UNCOMMENT ME

(defn home-handler
  [_req]
  (resource-response "index.html"))

(defn -main
  []
  (jetty/run-jetty home-handler {:port 3000
                                 :join? false}))
