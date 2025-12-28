FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY delivery-service/pom.xml delivery-service/
RUN mvn -B -e -C dependency:go-offline -DskipTests
COPY . .
RUN mvn clean package -DskipTests -pl delivery-service -am

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/delivery-service/target/*.jar app.jar
EXPOSE [PORT]
ENTRYPOINT ["java", "-jar", "app.jar"]

