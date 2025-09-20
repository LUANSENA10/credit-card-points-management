# Estágio 1: Build com Maven
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio 2: Imagem final de execução
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Copia o JAR do estágio de build
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]