
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY payment-service/pom.xml payment-service/pom.xml

RUN mvn -B -e -C -DskipTests dependency:go-offline

COPY . .
RUN mvn clean package -DskipTests -pl payment-service -am


FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=build /build/payment-service/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
