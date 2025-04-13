FROM openjdk:17-jdk-alpine
WORKDIR /app
VOLUME /tmp
COPY target/Resi-Jonathan-Ngo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]