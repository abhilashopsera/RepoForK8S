# Use OpenJDK 17 base image
FROM eclipse-temurin:17-jdk
# Set working directory inside the container
WORKDIR /app
# Copy the built JAR file into the container
COPY target/BestHospital-0.0.1-SNAPSHOT.jar app.jar
# Expose the application port
EXPOSE 8081
# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
#JUST A COMMIT
