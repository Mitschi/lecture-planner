FROM openjdk:8-jdk-alpine

COPY target/lecture-planner-lecture-service-1.0-SNAPSHOT.jar /spring-boot.jar
ENV MYSQL_HOST=host.docker.internal

EXPOSE 8082

ENTRYPOINT ["java","-jar","spring-boot.jar"]
