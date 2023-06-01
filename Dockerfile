FROM eclipse-temurin:20-jdk-alpine AS build
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests

FROM eclipse-temurin:20-jdk-alpine
VOLUME /tmp
COPY --from=build target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
