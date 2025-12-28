FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY payment-service/pom.xml payment-service/
RUN mvn -B -e -C dependency:go-offline -DskipTests
COPY . .
RUN mvn clean package -DskipTests -pl payment-service -am

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/payment-service/target/*.jar app.jar
EXPOSE [PORT]
ENTRYPOINT ["java", "-jar", "app.jar"]
