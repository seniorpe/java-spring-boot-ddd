# Guía de ejecución del Proyecto

Este proyecto es una API RESTful basada en Spring Boot que maneja usuarios y teléfonos co persistencia en una base de datos H2.

## Índice

1. [Pre-requisitos](#pre-requisitos)
2. [Compilar el Proyecto](#compilar-el-proyecto)
3. [Desplegar en Docker](#desplegar-en-docker)
4. [Ejecutar Pruebas Unitarias y Karate](#ejecutar-pruebas-unitarias-y-karate)
5. [Validar endpoints en Postman](#validar-endpoints-en-postman)

## Pre-requisitos

Antes de comenzar, asegúrate de tener instaladas las siguientes herramientas:

- [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven 3.8.8](https://maven.apache.org/download.cgi)
- [Docker](https://www.docker.com/products/docker-desktop)
- [Docker Compose](https://docs.docker.com/compose/install/)

## Compilar el Proyecto

1. **Clona el repositorio:**

   ```bash
   cd sources
   git clone https://github.com/seniorpe/java-spring-boot-ddd.git
   
   
2. **Compilar el proyecto usando Maven:**

   ```bash
   cd java-spring-boot-ddd
   mvn clean install -DskipTests
   
 Esto descargará las dependencias, compilará el código fuente y ejecutará sin las pruebas unitarias.

## Desplegar en Docker

1. **Asegúrate de que Docker se encuentre funcionando.**
   
2. **Desplegar en Docker**

   ```bash
   docker build -t java-spring-boot-ddd .
   docker run -d -p 8181:8181 java-spring-boot-ddd
   
Esto levantará el proyecto en Docker.

## Ejecutar Pruebas Unitarias

1. **Ejecuta los tests:**

   ```bash
   mvn test
   
Esto ejecutará todas las pruebas unitarias.

## Validar Postman
1. **Importar la colección a Postman:**
   ```bash
   Importar->Seleccionar fichero: RESTful.postman_collection
   
Al realiza la importacion se tendrá todos los endpoints requeridos.

2. **Screenshot de la colección Postman**





