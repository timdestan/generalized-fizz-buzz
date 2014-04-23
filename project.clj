(defproject generalized-fizz-buzz "0.1.0-SNAPSHOT"
  :description "A generalized FizzBuzz"
  :url "https://github.com/timdestan/generalized-fizz-buzz"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [expectations "2.0.6"]]
  :main ^:skip-aot generalized-fizz-buzz.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :plugins [[lein-autoexpect "1.0"]])
