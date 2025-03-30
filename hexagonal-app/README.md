# Hexagonal App

## Descripción

Este proyecto es una aplicación backend desarrollada con Spring Boot utilizando la arquitectura hexagonal. Está diseñada para ser escalable, modular y fácil de mantener. El sistema permite gestionar información sobre empresas y transferencias, con endpoints RESTful expuestos para la interacción.

## Tecnologías utilizadas

- **Java 11**: La aplicación está desarrollada utilizando Java 11, asegurando un entorno moderno y eficiente para la ejecución del backend.
- **Spring Boot 2.7.9**: Framework principal para el desarrollo de la aplicación.
- **Spring Data JPA**: Utilizado para la gestión de la base de datos con entidades de JPA.
- **MySQL**: Base de datos relacional utilizada para almacenar la información.
- **Swagger (Springdoc OpenAPI)**: Documentación automática de los endpoints RESTful expuestos.
- **Lombok**: Librería utilizada para reducir el boilerplate en el código, como getters, setters, constructores, etc.

## Endpoints

- **Empresas que hicieron transferencias el último mes**
- **Empresas que se adhirieron el último mes**
- **Endpoint para la adhesión de una empresa**
- **Endpoint para crear una nueva transferencia de una empresa**

## Acceso a la documentación Swagger

La documentación de los endpoints expuestos está disponible a través de Swagger en la siguiente URL:
http://localhost:8080/swagger.html
