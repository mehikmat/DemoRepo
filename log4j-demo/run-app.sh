javac -cp lib/log4j-1.2.17.jar -sourcepath conf/log4j.properties  src/test/log4j/*.java
java -cp lib/log4j-1.2.17.jar:./src:conf/ test.log4j.Log4jTest
