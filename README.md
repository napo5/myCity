## myCity

Software that aims to create a verified channel for communication between citizens and municipality, giving citizens the opportunity to report problems and giving municipality a way to listen the needs of citizens.
The purpose is to improve the collaboration between the two parts, as the municipality can ask the partecipation of the citizens in solving part of the problems reported.

# Running myCity locally

myCity is a Spring Boot application built using Maven. You can build a jar file and run it from the command line:

```sh
git clone https://github.com/napo5/myCity.git
cd myCity\mycity.release.0.0.1
mvn package
java -jar target/<release_name>.jar
```
The software is preconfigured to running on `http://localhost:8080/` but you can also specify ip and port in the console:  
for example `java -jar target/<release_name>.jar --server.port=8081 --server.ip=0.0.0.0`
