FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:8-jdk-alpine
COPY target/Matrix-Backend-0.0.1-SNAPSHOT.jar server-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/server-0.0.1.jar"]
