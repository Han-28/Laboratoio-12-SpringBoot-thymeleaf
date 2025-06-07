# Usa una imagen base de OpenJDK
FROM eclipse-temurin:17-jdk-alpine

# Carpeta dentro del contenedor donde estará la app
WORKDIR /app

# Copia el archivo JAR generado (cambia el nombre si es otro)
COPY target/Laboratorio-12-SpringBoot-thymeleaf-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto que usa Spring Boot (por defecto 8080)
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java","-jar","/app/app.jar"]
