# JavAPI

Ejemplo de estructura para una API Rest con Java y SpringBoot

## Rutas
La API está desplegada en el puerto 3000.

### GET /
Muestra un saludo de bienvenida para la API

### GET /nota
Obtiene todas las notas guardads en la db

### GET /nota/obtener/{idNota}
Obtiene una nota específica según el id pasado por la url

### POST /nota/
Guarda una nota. 
Necesita los parámetros en **formdata**

- titulo
- cuerpo

### PUT /nota/{idNota}
Edita una nota específica según el id pasado por la url
Necesita los parámetros en **formdata**

- titulo
- cuerpo

### DELETE /nota/{idNota}
Elimina una nota específica según el id pasado por la url

## Patrón de Diseño
El patrón de diseño usado en este desarrollo es MVC. Sin embargo, presenta una variable en dónde se integran nuevos componentes en las capas. Un diagrama a continuación:

![alt text](Docs/EsquemaServicioDAO.png)

### Models

#### DTOS

- Estas clases son finalmente objetos de transporte de datos
- Su objetivo es compartir datos en la aplicación, transportar, compartir entre las distintas capas

#### Entities

- Estas clases están direcamente relacionadas con las entidades de la base de datos
- Son una repressentación de la base de datos fidedignamente
- Además se agregan las relaciones como una propiedad en la clase (revisar)

### Persistence

#### DAOS

El objetivo de esta capa es:

- Obtiene los datos usando el JPA

### Services

El objetivo de esta capa es:

- Obtiene los datos consultando a los DAOS

## Arquitectura

### Diagrama de clases (próximamente) 

- Pronto

### Modelo de datos

- Al tratarse de un ejemplo, es muy simple

![alt text](docs/ModeloDeDatos.png)


## Futuro

- Terminar la estructura de Servicios, Modelos, DAOs y conectar con una base de datos
- Escribir la documentación de la arquitectura incluyendo un diagrama de clases y del modelo de datos

## Dependencias Usadas
### log4j2
Usada para loggear o escribir mensajes de salida en un archivo de texto. Además permite colorear las salidas de los mensajes para fácil reconocimiento de la gravedad de los mensajes
