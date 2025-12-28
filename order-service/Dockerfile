# ======================
# Build Stage
# ======================
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /build

COPY pom.xml .
COPY order-service/pom.xml order-service/pom.xml

RUN mvn -B -e -C -DskipTests dependency:go-offline

COPY . .
RUN mvn clean package -DskipTests -pl order-service -am

# ======================
# Runtime Stage
# ======================
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=build /build/order-service/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
