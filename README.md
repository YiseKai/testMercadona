![image](https://user-images.githubusercontent.com/11297328/212533888-f5ee61db-347d-4c86-88dd-8deb6bda4b12.png)

# Prueba técnica para Mercadona - Jesús Manuel García Luz

Para la prueba he desarrollado un servicio API Rest con Swagger para facilitar la corrección evitando el uso de Postman y compartir una collection que haga uso de la misma.

<img width="1425" alt="image" src="https://user-images.githubusercontent.com/11297328/212533673-216285e2-1750-40dc-9a2a-7271b7785f0a.png">

El servicio, está diseñado en Java 11 usando el framework de SpringBoot. Además, se añaden librerías externas como una base de datos H2, y un gestor de entidades como Lombok gracias al uso de Maven.
Para poder iniciar el servicio bastará con ejecutar la clase TestApplication.java

# Ejemplo de uso

Mercadona ha facilitado en su documento dos EAN de productos. Probemos con 8437008459059.
Para ello, necesitamos correr el servicio y abrir la direccion http://localhost:8080/swagger-ui/index.html y abrimos la seccion GET /mercadona/{ean} la cual nos ofrece información sobre la composición del EAN y hacemos clic en `Try it out`.

<img width="1422" alt="image" src="https://user-images.githubusercontent.com/11297328/212534381-35ee59c9-5c3c-4a3c-83d1-6c08d9cc03ae.png">

Posteriormente introducimos el EAN a consultar y hacemos clic en Execute para obtener la respuesta del servicio.

<img width="1406" alt="image" src="https://user-images.githubusercontent.com/11297328/212534475-548907d0-c186-4efa-8562-463dcdedda5a.png">

Además, Swagger nos da la oportunidad de copiar el servicio JSON de respuesta.

{
  "provider": "Hacendado",
  "productCode": "45905",
  "address": "Oficinas Mercadona"
}

Para este servicio se han realizado las validaciones correspondientes con el propio manejo de excepciones.
Además, se ha podido implementar una CRUD que se puede ver en Swagger.

Como aclaración, en el ejercicio del CRUD se ha decidido que el EAN sea único ya que he considerado que un código de barras de un producto no puede ser idéntico a otro.
