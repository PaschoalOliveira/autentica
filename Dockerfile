FROM openjdk:11-jdk

ARG APP_JAR_NAME=autentica
ARG APP_JAR_VERSION=0.0.1

WORKDIR /app

ADD target/${APP_JAR_NAME}-${APP_JAR_VERSION}.jar /app/app.jar
EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
