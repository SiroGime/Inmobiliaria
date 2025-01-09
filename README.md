## Proyecto Inmobiliaria

- Java 21 - Spring Boot
- Maven 3.9+
- SQLite (para almacenamiento local)

Este repositorio contiene los microservicios del sistema inmobiliario. Actualmente incluye:

- Usuarios: Gestión de usuarios registrados.
- Inmuebles: Gestión de propiedades disponibles para alquiler o venta.

Microservicio de Usuarios
- URL Base: http://localhost:8081/usuario
- Método	Ruta	Descripción
- GET	/	Obtiene la lista de todos los usuarios registrados.
- GET	/{id}	Obtiene los detalles de un usuario específico por su ID.
- POST	/	Crea un nuevo usuario enviando un objeto Usuario en el cuerpo de la solicitud.
- PUT	/{id}	Actualiza un usuario existente por su ID enviando un objeto Usuario en el cuerpo.
- DELETE	/{id}	Elimina un usuario por su ID.

Microservicio de Inmuebles.
- URL Base: http://localhost:8080
- Entidad		    Ruta Base	      Métodos Disponibles
- Casas	        /casa		        GET: Listar todas las casas.
                        	    POST: Agregar una nueva casa.
- Departamentos	/departamento	   GET: Listar todos los departamentos.
				POST: Agregar un nuevo departamento.
-Locales		/local		GET: Listar todos los locales.
				POST: Agregar un nuevo local.
- PHs		/ph		GET: Listar todos los PHs.
				POST: Agregar un nuevo PH.
- Terrenos	/terreno	GET: Listar todos los terrenos.
				POST: Agregar un nuevo terreno.
- Inmuebles	/inmueble	GET /operacion/{tipoOperacion}: Busca inmuebles por tipo de operación (COMPRA o ALQUILER).

Cómo ejecutar

Clona el repositorio:
git clone https://github.com/tuusuario/proyecto-inmobiliaria.git
cd proyecto-inmobiliaria

Para el Microservicio de Usuarios:
cd Usuarios
mvn spring-boot:run

Para el Microservicio de Inmuebles:
cd ../Inmuebles
mvn spring-boot:run

Próximos pasos
- Añadir un microservicio de Notificaciones para alertar a los usuarios sobre nuevos inmuebles.
- Configurar integración continua (CI/CD) para automatizar los despliegues.
- Implementar contenedores con Docker para facilitar la portabilidad y el despliegue.
- Mejorar la seguridad con autenticación y autorización usando JWT.
