FROM amazoncorretto:11-alpine-jdk
MAINTAINER baeldung.com
COPY target/stack-0.0.1-SNAPSHOT.jar stack-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/stack-0.0.1-SNAPSHOT.jar"]