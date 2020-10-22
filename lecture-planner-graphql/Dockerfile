FROM openjdk:8-jdk-alpine

COPY target/lecture-planner-graphql-1.0-SNAPSHOT.jar /spring-boot.jar
ENV EMPLOYEE_HOST=host.docker.internal
ENV LECTURE_HOST=host.docker.internal

EXPOSE 8083

ENTRYPOINT ["java","-jar","spring-boot.jar"]
