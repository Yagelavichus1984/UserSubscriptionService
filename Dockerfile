FROM openjdk:17-jdk-slim
COPY target/user-subscription-service.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
