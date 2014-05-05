(ns clojure-server.parameter-decoder-spec
  (:require [clojure-server.parameter-decoder :refer :all])
  (:require [speclj.core :refer :all]))

(describe "parameter decoder"
  (it "Decodes characters required by cob-spec"
      (should=
        "string=Operators <, >, =, !=; +, -, *, &, @, #, $, [, ]: \"is that all\"?"
        (decode "string=Operators%20%3C%2C%20%3E%2C%20%3D%2C%20!%3D%3B%20%2B%2C%20-%2C%20*%2C%20%26%2C%20%40%2C%20%23%2C%20%24%2C%20%5B%2C%20%5D%3A%20%22is%20that%20all%22%3F"))))
