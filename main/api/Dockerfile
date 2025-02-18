FROM openjdk:18-jdk-slim

RUN apt-get update && apt-get install -y netcat maven
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
ARG JAR_FILE=target/*.jar
RUN cp ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]