FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY delivered-service/pom.xml delivered-service/
RUN mvn -B -e -C dependency:go-offline -DskipTests
COPY . .
RUN mvn clean package -DskipTests -pl delivered-service -am

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/delivered-service/target/*.jar app.jar
EXPOSE [PORT]
ENTRYPOINT ["java", "-jar", "app.jar"]
