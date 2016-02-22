Aplicación web diseñada para el manejo de un sistema de vuelos en línea.
Este proyecto implementa las siguientes funcionalidades:
- CRUD Pasajero
- CRUD Avión
- CRUD Ruta
- CRUD VUelo
- Reserva de vuelo
- Generación de reporte (Funcionalidad parcial)


HERRAMIENTAS
- Eclipse IDE: Eclipse Mars.1 (4.5.1)
- Hibernate: Versión 5.1
- Spring: Versión 4.2.4
- PostgreSQL: Versión 9.4
- Apache Tomcat: Version 7.0

La aplicación fue desarrollada en su totalidad con el uso de las herramientas previamente descritas.
Su diseño se centra en el uso de capas basado en la arquitectura de SpringWeb.
- Capa de modelo (Model): Contiene las entidades creadas a partir de la base de datos
- Capa de DAO: Capa que se comunica directamente con las entidades del modelo
- Capa de servicios: Capa que se comunica con las clases de repositorio DAO
- Capa de controladores: Capa que contiene los controladores encargados de la presentación del modelo
- Capa de vista (JSP): Capa que contiene las páginas web

Así mismo, se definieron clases de configuración relativas a Spring.

Para correr la aplicación es necesario crear un nuevo proyecto en Eclipse y agregar el código fuente. Esta aplicación hace uso de Maven para la configuración y despliegue del proyecto. 
Corre con el servidor Tomcat7 embebido de Maven.
Click en Run Configuration-> Especificar Base directory y goal(tomcat7:run) (En la ventana emergente)->Run 

Es necesario instalar PostgreSQL y crear una nueva base de datos llamada "AdministradorVuelos". El script AdministradorVuelos.sql contiene la creación de las tablas y la inserción de valores de la tabla aeropuerto (Inserción web no fue considerada para los aeropuertos).