
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY gateway-service/pom.xml gateway-service/pom.xml

RUN mvn -B -e -C -DskipTests dependency:go-offline

COPY . .
RUN mvn clean package -DskipTests -pl gateway-service -am


FROM openjdk:17-jre-slim
COPY target/gateway-service-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
