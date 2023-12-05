# Utilizar una imagen base oficial de Maven para la compilación
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
# Copiar el archivo pom.xml y los archivos de la aplicación
COPY pom.xml .
COPY src ./src
# Construir la aplicación con Maven
RUN mvn -f pom.xml clean package

# Utilizar una imagen base de OpenJDK para ejecutar la aplicación
FROM openjdk:17
WORKDIR /app
# Copiar el archivo jar desde el contenedor de compilación al contenedor de ejecución
COPY --from=build /app/target/*.jar backend_trabajofinal-0.0.1-SNAPSHOT.jar
# Expone el puerto en el que la aplicación se ejecutará
EXPOSE 8087
# Comando para ejecutar la aplicación
CMD ["java", "-jar", "backend_trabajofinal-0.0.1-SNAPSHOT.jar"]

FROM mysql:5.7.25
LABEL maintainer="Joel Arauzo"

ENV MYSQL_ROOT_PASSWORD=holt123
ENV MYSQL_DATABASE=abcsaber
ENV MYSQL_ROOT_HOST=root

EXPOSE 3306