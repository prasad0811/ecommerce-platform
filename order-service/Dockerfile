FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY order-service/pom.xml order-service/
RUN mvn -B -e -C dependency:go-offline -DskipTests
COPY . .
RUN mvn clean package -DskipTests -pl order-service -am

FROM eclipse-temurin:17-jre-alpine  
WORKDIR /app
COPY --from=build /app/order-service/target/*.jar app.jar  
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
