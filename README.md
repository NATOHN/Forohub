
# Foro Hub

## Descripción

**Foro Hub API** es una API RESTful desarrollada con **Spring Boot** que permite la gestión de tópicos en un foro. La API ofrece funcionalidades para crear, leer, actualizar y eliminar tópicos, y está protegida mediante **JWT (JSON Web Token)** para asegurar que solo los usuarios autenticados puedan acceder a ciertos recursos.

La aplicación almacena los tópicos en una base de datos **MySQL**, y utiliza **Spring Security** para la autenticación de usuarios, mientras que **Flyway** se utiliza para gestionar las migraciones de la base de datos.

## Características

- **Gestión de Tópicos (CRUD)**: Los usuarios pueden crear, leer, actualizar y eliminar tópicos.
- **Autenticación JWT**: Los usuarios deben autenticarse con un **token JWT** para acceder a los endpoints protegidos.
- **Base de Datos**: Se utiliza **MySQL** para almacenar los datos de los tópicos.
- **Migraciones con Flyway**: Las tablas de la base de datos se gestionan con **Flyway**, lo que permite aplicar cambios estructurales de forma eficiente.
- **Spring Security**: Protege los endpoints y gestiona la autenticación de los usuarios.
- **Paginación**: Los resultados de los tópicos pueden ser paginados para optimizar el rendimiento en solicitudes grandes.

## Tecnologías Utilizadas

- **Java 17** o superior
- **Spring Boot 3.x** (incluyendo Spring Security, Spring Data JPA, Spring Web)
- **JWT (JSON Web Token)** para autenticación
- **Flyway** para migración de base de datos
- **MySQL 8.0** o superior
- **BCryptPasswordEncoder** para cifrado de contraseñas

## Requisitos

Para ejecutar este proyecto en tu entorno local, necesitas tener instalados los siguientes programas:

- **Java 17 o superior**
- **Maven 4.x o superior**
- **MySQL 8.x o superior**
- **Postman** o **Insomnia** (para probar los endpoints)

## Instalación

### 1. Clonar el repositorio

Primero, clona este repositorio en tu máquina local:

```bash
git clone https://github.com/tu_usuario/foro-hub.git


Desarrollado por Leonardo Alvarado
