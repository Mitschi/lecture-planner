FROM openjdk:8-jdk-alpine

COPY target/lecture-planner-frontend-1.0-SNAPSHOT.jar /spring-boot.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","spring-boot.jar"]
