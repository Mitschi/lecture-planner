FROM openjdk:8-jdk-alpine

COPY target/lecture-planner-employee-service-1.0-SNAPSHOT.jar /spring-boot.jar
ENV MYSQL_HOST=host.docker.internal

EXPOSE 8081

ENTRYPOINT ["java","-jar","spring-boot.jar"]
