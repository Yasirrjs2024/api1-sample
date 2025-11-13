# Dockerfile
# ---- Build stage ----
FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -q -e -DskipTests=true package

# ---- Runtime stage ----
FROM eclipse-temurin:21-jre
ENV SPRING_PROFILES_ACTIVE=docker
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
# Expose the port inside container (Spring will read PORT env var from CBH)
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
