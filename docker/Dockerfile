FROM openjdk:8

MAINTAINER Colin But colin.but@outlook.com

EXPOSE 8090

# Install artifact
VOLUME /tmp
ADD user-service-1.0-SNAPSHOT-with-dependencies.jar user-service.jar
RUN sh -c 'touch /user-service.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/user-service.jar"]