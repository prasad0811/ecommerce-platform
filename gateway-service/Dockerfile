FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY gateway-service/pom.xml gateway-service/
RUN mvn -B -e -C dependency:go-offline -DskipTests
COPY . .
RUN mvn clean package -DskipTests -pl gateway-service -am

FROM eclipse-temurin:17-jre-alpine  
WORKDIR /app
COPY --from=build /app/gateway-service/target/*.jar app.jar  
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
