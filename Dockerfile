# Step 1: Build stage - Maven to build the Spring Boot applications
FROM maven:3.8.4-openjdk-11 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the entire codebase (assuming all Spring Boot apps are in submodules)
COPY . .

# Download the dependencies (this will cache dependencies unless pom.xml changes)
RUN mvn clean install -DskipTests

# Build all the Spring Boot apps (replace the paths with your actual modules)
RUN mvn clean package -DskipTests

# Step 2: Runtime stage - Use a smaller base image to run the app
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy all compiled JAR files from the build stage
COPY --from=build /app/*/target/*.jar ./apps/

# Expose the port the app will run on (adjust if needed)
EXPOSE 8080

# Default entrypoint: The Spring Boot application to run (replace with dynamic logic if needed)
CMD ["java", "-jar", "apps/spring-boot-app.jar"]
