# Dockerfile
# ---- Build stage ----
FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -q -e -DskipTests=true package

# ---- Runtime stage ----
FROM eclipse-temurin:21-jre
# ENV SPRING_PROFILES_ACTIVE=docker
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
# CBH Cloud injects PORT env var. Default to 8080.
ENV PORT=8080
EXPOSE 8080
# Force Spring Boot to bind to CBH Cloud's port
ENTRYPOINT ["sh", "-c", "java -jar /app/app.jar --server.port=$PORT"]
