(ns clojure-server.request-spec
  (:require [clojure-server.request :refer :all])
  (:require [speclj.core :refer :all]))

(describe "request"
  (it "parses request method"
      (should= "GET" ((parse "GET / HTTP/1.1") :method)))

  (it "parses request path"
      (should= "/" ((parse "GET / HTTP/1.1") :path)))

  (it "parses request http version"
      (should= "HTTP/1.1" ((parse "GET / HTTP/1.1") :http-version)))

  (it "parses a single header"
      (should= ["Foo: Bar"] ((parse "GET / HTTP/1.1\r\nFoo: Bar") :headers)))

  (it "parses multiple headers"
      (should= ["Foo: Bar" "Boo: Far"] ((parse "GET / HTTP/1.1\r\nFoo: Bar\nBoo: Far") :headers)))

  (it "parses body"
      (should= "Body" ((parse "GET / HTTP/1.1\r\nHeaders\r\nBody") :body))))
