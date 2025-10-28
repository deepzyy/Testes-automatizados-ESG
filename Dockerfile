FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml /app/
COPY src /app/src
RUN mvn -q -DskipTests=true package || true
CMD ["mvn", "test", "-q"]