# Usa una imagen base oficial de Java
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado en el contenedor
COPY target/restful-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que correrá la aplicación
EXPOSE 8181

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
