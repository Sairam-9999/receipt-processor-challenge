FROM openjdk:17-jdk-slim


COPY ./target/ReceiptProcessor-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]