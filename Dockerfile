# Use a lightweight Java 21 image
FROM eclipse-temurin:21-jdk-alpine

# Create app directory
WORKDIR /app

# Copy the built JAR file into the container
COPY target/*.jar app.jar

# Expose the port (will be overridden in Docker run command)
EXPOSE 8080

# Command to run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]