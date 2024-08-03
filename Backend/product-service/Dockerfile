# Use a base image with Java runtime environment
FROM openjdk:17-jdk-slim



# Copy the JAR file into the container
COPY target/product-service-1.0-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app.jar"]
