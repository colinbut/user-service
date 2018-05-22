# User Service

[![Build Status](https://travis-ci.org/colinbut/user-service.svg?branch=master)](https://travis-ci.org/colinbut/user-service)

Microservice for user functionality. 

Technologies:

+ Java 7
+ Spring Framework 4
+ Jetty
+ Datastax Cassandra Driver
+ Apache Cassandra


Built using Java with the Spring framework. It runs inside a Jetty server (a lightweight web container/server). Application connects to
Cassandra datastore (NoSQL)

Below:

![Image of technology diagram](etc/diagram.png)


### Build

```bash
mvn clean install
```

### Deployment

#### using Docker Compose

```bash
rm docker/user-service-1.0-SNAPSHOT-with-dependencies.jar
cp target/user-service-1.0-SNAPSHOT-with-dependencies.jar docker/
cd docker;
docker-compose up
```

#### Bringing User Service + Cassandra DB up individually

__User Service__

```bash
rm docker/user-service-1.0-SNAPSHOT-with-dependencies.jar
cp target/user-service-1.0-SNAPSHOT-with-dependencies.jar docker/
cd docker;
docker build -f dockerfiles/userservice.app -t user-service:1.0-SNAPSHOT .
docker run user-service:1.0-SNAPSHOT
```

__Cassandra DB__

```bash
cd docker;
docker build -f dockerfiles/cassandra.db -t cassandra-db:1.0-SNAPSHOT .
docker run cassandra-db:1.0-SNAPSHOT
```

then link the two containers together so the User Service microservice can talk to the Cassandra db.

```bash
docker run --link cassandra-db:1.0-SNAPSHOT --name user-service:1.0-SNAPSHOT -p 8080:8080 user-service:1.0-SNAPSHOT
```