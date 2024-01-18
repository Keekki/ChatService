# Build stage
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN mvn clean install -DskipTests && mvn package -DskipTests

# Package stage
FROM openjdk:17-oracle
COPY --from=build /app/target/*.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
