# JavAPI

Ejemplo de estructura para una API Rest con Java y SpringBoot

## Rutas
La API está despegada en el puerto 3000.
### GET /
Muestra un saludo
### GET /obtener
Prueba de método GET
### PUT /actualizar
Prueba de método PUT
Pide como parámetro obligatorio, en form-data, `idusuario`
### POST /postear
Prueba de método POST
### DELETE /eliminar
Prueba de método DELETE

## Arquitectura

Este ejemplo sigue un patrón MVC clásico y básico

### Diagrama de clases (próximamente) 

- Pronto

### Modelo de datos (próximamente)

- Pronto

## Futuro

- Terminar la estructura de Servicios, Modelos, DAOs y conectar con una base de datos
- Escribir la documentación de la arquitectura incluyendo un diagrama de clases y del modelo de datos

## Dependencias Usadas
### log4j2
Usada para loggear o escribir mensajes de salida en un archivo de texto. Además permite colorear las salidas de los mensajes para fácil reconocimiento de la gravedad de los mensajes