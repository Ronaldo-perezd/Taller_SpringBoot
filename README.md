
# Taller Electiva II Con SpringBoot

Taller realizado con documentacion en Swagger-Ui mediante el link de inicio

http://localhost:8080/swagger-ui/index.html#/

El proyecto solo se debe clonar, descargar las librerias, y ejecutar (IDE utilizado: IntelliJ IDEA). 

La base de datos que se manejo es Postgrest en la nube, con la plataforma: Supabase (https://supabase.com/)



# Documentación de la API

Iniciar por registrar un usuario, luego un ticket, y terminar añadiendo comentarios.

## user-controller:
```http
  POST /users
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `Long` | **identificador del usuario**.  |
| `username` | `String` | **Nombre del usuario**.  |
| `email` | `String` | **correo electrónico del usuario**.  |

```http
  GET /users
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `Long` | **identificador del usuario**.  |


## comment-controller:

#### Get all Comment

```http
/comments
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `Long` |**Identifica todos los comentarios.**|

#### Get Comments of the ticket

```http
/comments/ticket/{ticketId}/comments
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `ticketId`| `Long` |**Identifica un ticket, y trae sus comentarios.**|

#### Post

```http
/comments
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`| `Long` | Identifica un comentario.|
| `content`| `String` | Muestra el contenido de un comentario.|
| `ticketId`| `Long` | Identifica un ticket.|
| `title`| `String` |El título o nombre del ticket|
| `description`| `String` |Una descripción detallada del ticket|
| `status`| `String` |"Abierto", "En progreso", "Cerrado"|
| `assignedUser`| `data` | Un objeto que representa el usuario asignado al ticket.|
| `id`| `Long` |Un identificador único para el usuario.|
| `username`| `String` |El nombre de usuario del usuario asignado al ticket.|
| `email`| `Long` |La dirección de correo electrónico del usuario asignado al ticket.|
| `author`| `data` |objeto que representa el autor del comentario.|
| `id`| `Long` |Un identificador único para el usuario.|
| `username`| `String` |El nombre de usuario del autor del comentario.|
| `email`| `String` |La dirección de correo electrónico del autor del comentario.|

#### Put

```http
/comments/{id}
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `Long` | **identificador del comentario**.  |
| `newContent` | `String` | **Nuevo comentario**.  |


## ticket-controller:

```http
  POST /tickets
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `title`| `String` |El título o nombre del ticket|
| `description`| `String` |Una descripción detallada del ticket|
| `status`| `String` |"Abierto", "En progreso", "Cerrado"|
| `assignedUser`| `data` | Un objeto que representa el usuario asignado al ticket.|
| `id`| `Long` |Un identificador único para el usuario.|
| `username`| `String` |El nombre de usuario del usuario asignado al ticket.|
| `email`| `Long` |La dirección de correo electrónico del usuario asignado al ticket.|


```http
  GET /tickets
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `ticketId` | `Long` | **identifica todos los tickets**.  |

```http
  GET /tickets/{id}
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `ticketId` | `Long` | **identifica un ticket en especifico**.  |

```http
  PUT /tickets/{id}/close
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `ticketId` | `Long` | **identificador del ticket**.  |
| `status` | `String` | **Modifica el estado del ticket "Closed"**.  |