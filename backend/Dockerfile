# Use a imagem base com OpenJDK 21
FROM openjdk:21-jdk-slim

# Defina o argumento para o JAR
ARG JAR_FILE=target/myApi-0.0.1-SNAPSHOT.jar

# Copie o JAR da sua aplicação para o contêiner
COPY target/myApi-0.0.1-SNAPSHOT.jar app.jar

# Defina o ponto de entrada para a aplicação
ENTRYPOINT ["java", "-jar", "/app.jar"]
