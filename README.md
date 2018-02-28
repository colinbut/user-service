# User Service

[![Build Status](https://travis-ci.org/colinbut/user-service.svg?branch=master)](https://travis-ci.org/colinbut/user-service)

Microservice for user functionality. 

Technologies:

+ Java 6
+ Spring Framework 4
+ Jetty
+ Datastax Cassandra Driver


Built using Java with the Spring framework. It runs inside a Jetty server (a lightweight web container/server). Application connects to
Cassandra datastore (NoSQL)

Below:

![Image of technology diagram](etc/diagram.png)


### Build

```bash
mvn clean install
```

### Deployment

```bash
rm docker/user-service-1.0-SNAPSHOT-with-dependencies.jar
cp target/user-service-1.0-SNAPSHOT-with-dependencies.jar docker/
cd docker;
docker build -t user-service:1.0-SNAPSHOT .
docker-compose up
```