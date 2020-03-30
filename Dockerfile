FROM openjdk:8-jdk-alpine
MAINTAINER Amit Fegade (amitf@gamil.com)
COPY target/*.jar  app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]