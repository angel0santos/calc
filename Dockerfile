FROM openjdk:8-jdk-alpine
MAINTAINER asantos.com
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} back.jar
ENTRYPOINT ["java","-jar","/back.jar"]