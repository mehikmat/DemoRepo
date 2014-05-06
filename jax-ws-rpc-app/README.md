WebService using JAX-WS RPC
-------------------------
This is simple app which depicts basics of jax-ws api to create RPC

How to run app
-------------
```
$ git clone https://github.com/mehikmat/DemoRepo/jax-ws-rpc-app
$ cd DemoRepo/jax-ws-rpc-app
$ gradle clean
$ gradle build
$ gradle jar
```
Start server
`$ java -jar build/libs/jax-ws-rpc-app.jar test.jaxws.server.publisher.CalculatorServicePublisher`

Start test client
`$ java -jar build/libs/jax-ws-rpc-app.jar test.jaxws.client.CalculatorServiceClient`

Java Web Service Client via wsimport tool
------------------------------------------------------------------------------------
If you want generate client stub classes and interfaces yourself then use below way:

`wsimport`(jdk_home/bin) tool to parses the published wsdl file,and generates necessary client files (stub)
 to access the published web service.

 Issue Command:
 `wsimport -keep http://localhost:9999/ws/hello?wsdl`

 It will generate necessary client files, which is depends on the provided wsdl file.
 In this case, it will generate one interface and one service implementation file.
