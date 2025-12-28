FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app


COPY pom.xml .
COPY inventory-service/pom.xml inventory-service/pom.xml


RUN mvn -B -e -C -DskipTests dependency:go-offline


COPY . .


RUN mvn clean package -DskipTests -pl inventory-service -am


FROM eclipse-temurin:17-jre-alpine


WORKDIR /app


COPY --from=build /build/inventory-service/target/*.jar app.jar


EXPOSE 8082


ENTRYPOINT ["java", "-jar", "app.jar"]
