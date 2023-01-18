FROM openjdk:11 as build
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} SalesArea.jar
ENTRYPOINT ["java","-jar","SalesArea.jar"]
