# Proyecto Inmobiliaria

Backend de una plataforma inmobiliaria orientada a:

* **Agente / Inmobiliaria (staff interno):** publicar, editar y gestionar inmuebles.
* **Demandante (cliente):** consultar publicaciones y contactar a la inmobiliaria.

En esta etapa, los demandantes no se registran.

El acceso autenticado está orientado exclusivamente al staff interno.

---

## Stack tecnológico

* Java 21
* Spring Boot 3.4.1
* Maven 3.9+
* SQLite (persistencia local para desarrollo)

---

## Arquitectura

El repositorio implementa una arquitectura basada en microservicios compuesta por:

* `Usuarios`: autenticación y gestión de usuarios internos.
* `Inmueble`: gestión y consulta de propiedades para venta o alquiler.

Cada microservicio:

* Se ejecuta en un puerto independiente.
* Posee su propia base de datos.
* Se configura y despliega de manera autónoma.

---

# Microservicio `Usuarios`

* Módulo: `Usuarios`
* Puerto: `8081`
* Base URL: `http://localhost:8081`

## Endpoints principales

### Autenticación (staff)

`POST /api/v1/auth/login`

Inicia sesión de usuario interno y devuelve un token JWT.

### Gestión de usuarios (interno)

* `GET /usuario`

  Lista usuarios.
* `GET /usuario/{id}`

  Obtiene un usuario por ID.
* `POST /usuario`

  Crea usuario.
* `PUT /usuario/{id}`

  Actualiza usuario.
* `DELETE /usuario/{id}`

  Elimina usuario.

---

# Microservicio `Inmueble`

* Módulo: `Inmueble`
* Puerto: `8080`
* Base URL: `http://localhost:8080`

## Endpoints públicos (catálogo)

* `GET /casa`
* `GET /departamento`
* `GET /local`
* `GET /ph`
* `GET /terreno`
* `GET /inmueble/operacion/{tipoOperacion}`

  Busca inmuebles por operación (`VENTA` o `ALQUILER`).

## Endpoints de administración (staff)

* `POST /casa`
* `POST /departamento`
* `POST /local`
* `POST /ph`
* `POST /terreno`

Estos endpoints están pensados para uso interno y deben utilizar autenticación JWT.

---

# Seguridad

* El login del staff se realiza en el microservicio `Usuarios`.
* El token JWT se firma en `Usuarios`.
* El token es validado en `Inmueble`.
* Para desarrollo local, ambos microservicios deben compartir la misma clave JWT.

## Configuración recomendada

### Usuarios

`Usuarios/src/main/resources/application.properties`

<pre class="overflow-visible! px-0!" data-start="2337" data-end="2545"><div class="relative w-full my-4"><div class=""><div class="relative"><div class="h-full min-h-0 min-w-0"><div class="h-full min-h-0 min-w-0"><div class="border border-token-border-light border-radius-3xl corner-superellipse/1.1 rounded-3xl"><div class="h-full w-full border-radius-3xl bg-token-bg-elevated-secondary corner-superellipse/1.1 overflow-clip rounded-3xl lxnfua_clipPathFallback"><div class="pointer-events-none absolute inset-x-4 top-12 bottom-4"><div class="pointer-events-none sticky z-40 shrink-0 z-1!"><div class="sticky bg-token-border-light"></div></div></div><div class=""><div class="relative z-0 flex max-w-full"><div id="code-block-viewer" dir="ltr" class="q9tKkq_viewer cm-editor z-10 light:cm-light dark:cm-light flex h-full w-full flex-col items-stretch ͼk ͼy"><div class="cm-scroller"><div class="cm-content q9tKkq_readonly"><span>app.jwt.secret=CAMBIAR_POR_UN_SECRET_MUY_LARGO_MINIMO_32</span><br/><span>app.jwt.expiration-ms=86400000</span><br/><br/><span>app.admin.nombre=Admin Principal</span><br/><span>app.admin.email=admin@inmobiliaria.com</span><br/><span>app.admin.password=Admin1234!</span></div></div></div></div></div></div></div></div></div><div class=""><div class=""></div></div></div></div></div></pre>

### Inmueble

`Inmueble/src/main/resources/application.properties`

<pre class="overflow-visible! px-0!" data-start="2616" data-end="2690"><div class="relative w-full my-4"><div class=""><div class="relative"><div class="h-full min-h-0 min-w-0"><div class="h-full min-h-0 min-w-0"><div class="border border-token-border-light border-radius-3xl corner-superellipse/1.1 rounded-3xl"><div class="h-full w-full border-radius-3xl bg-token-bg-elevated-secondary corner-superellipse/1.1 overflow-clip rounded-3xl lxnfua_clipPathFallback"><div class="pointer-events-none absolute inset-x-4 top-12 bottom-4"><div class="pointer-events-none sticky z-40 shrink-0 z-1!"><div class="sticky bg-token-border-light"></div></div></div><div class=""><div class="relative z-0 flex max-w-full"><div id="code-block-viewer" dir="ltr" class="q9tKkq_viewer cm-editor z-10 light:cm-light dark:cm-light flex h-full w-full flex-col items-stretch ͼk ͼy"><div class="cm-scroller"><div class="cm-content q9tKkq_readonly"><span>app.jwt.secret=CAMBIAR_POR_UN_SECRET_MUY_LARGO_MINIMO_32</span></br></br><span># Destinatario
app.notifications.to=MAIL_DESTINO
# Gmail SMTP
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=MAIL_ORIGEN
spring.mail.password=APP_PASSWORD_GOOGLE</span></div></div></div></div></div></div></div></div></div><div class=""><div class=""></div></div></div></div></div></pre>

La propiedad `app.jwt.secret` debe coincidir en ambos servicios.

---

# Ejecución en entorno local

## 1. Clonar el repositorio

<pre class="overflow-visible! px-0!" data-start="2822" data-end="2923"><div class="relative w-full my-4"><div class=""><div class="relative"><div class="h-full min-h-0 min-w-0"><div class="h-full min-h-0 min-w-0"><div class="border border-token-border-light border-radius-3xl corner-superellipse/1.1 rounded-3xl"><div class="h-full w-full border-radius-3xl bg-token-bg-elevated-secondary corner-superellipse/1.1 overflow-clip rounded-3xl lxnfua_clipPathFallback"><div class="pointer-events-none absolute inset-x-4 top-12 bottom-4"><div class="pointer-events-none sticky z-40 shrink-0 z-1!"><div class="sticky bg-token-border-light"></div></div></div><div class=""><div class="relative z-0 flex max-w-full"><div id="code-block-viewer" dir="ltr" class="q9tKkq_viewer cm-editor z-10 light:cm-light dark:cm-light flex h-full w-full flex-col items-stretch ͼk ͼy"><div class="cm-scroller"><div class="cm-content q9tKkq_readonly"><span class="ͼs">git</span><span> clone https://github.com/SiroGime/Inmobiliaria.git</span><br/><span class="ͼs">cd</span><span> Inmobiliaria</span></div></div></div></div></div></div></div></div></div><div class=""><div class=""></div></div></div></div></div></pre>

## 2. Ejecutar microservicio `Usuarios`

### Linux / macOS

<pre class="overflow-visible! px-0!" data-start="2985" data-end="3031"><div class="relative w-full my-4"><div class=""><div class="relative"><div class="h-full min-h-0 min-w-0"><div class="h-full min-h-0 min-w-0"><div class="border border-token-border-light border-radius-3xl corner-superellipse/1.1 rounded-3xl"><div class="h-full w-full border-radius-3xl bg-token-bg-elevated-secondary corner-superellipse/1.1 overflow-clip rounded-3xl lxnfua_clipPathFallback"><div class="pointer-events-none absolute inset-x-4 top-12 bottom-4"><div class="pointer-events-none sticky z-40 shrink-0 z-1!"><div class="sticky bg-token-border-light"></div></div></div><div class=""><div class="relative z-0 flex max-w-full"><div id="code-block-viewer" dir="ltr" class="q9tKkq_viewer cm-editor z-10 light:cm-light dark:cm-light flex h-full w-full flex-col items-stretch ͼk ͼy"><div class="cm-scroller"><div class="cm-content q9tKkq_readonly"><span class="ͼs">cd</span><span> Usuarios</span><br/><span>./mvnw spring-boot:run</span></div></div></div></div></div></div></div></div></div><div class=""><div class=""></div></div></div></div></div></pre>

### Windows

<pre class="overflow-visible! px-0!" data-start="3046" data-end="3102"><div class="relative w-full my-4"><div class=""><div class="relative"><div class="h-full min-h-0 min-w-0"><div class="h-full min-h-0 min-w-0"><div class="border border-token-border-light border-radius-3xl corner-superellipse/1.1 rounded-3xl"><div class="h-full w-full border-radius-3xl bg-token-bg-elevated-secondary corner-superellipse/1.1 overflow-clip rounded-3xl lxnfua_clipPathFallback"><div class="pointer-events-none absolute inset-x-4 top-12 bottom-4"><div class="pointer-events-none sticky z-40 shrink-0 z-1!"><div class="sticky bg-token-border-light"></div></div></div><div class=""><div class="relative z-0 flex max-w-full"><div id="code-block-viewer" dir="ltr" class="q9tKkq_viewer cm-editor z-10 light:cm-light dark:cm-light flex h-full w-full flex-col items-stretch ͼk ͼy"><div class="cm-scroller"><div class="cm-content q9tKkq_readonly"><span class="ͼs">cd</span><span></span><span class="ͼt">Usuarios</span><br/><span>.\</span><span class="ͼt">mvnw</span><span>.</span><span class="ͼt">cmd</span><span></span><span class="ͼt">spring-boot</span><span class="ͼn">:</span><span class="ͼt">run</span></div></div></div></div></div></div></div></div></div><div class=""><div class=""></div></div></div></div></div></pre>

---

## 3. Ejecutar microservicio `Inmueble`

### Linux / macOS

<pre class="overflow-visible! px-0!" data-start="3169" data-end="3215"><div class="relative w-full my-4"><div class=""><div class="relative"><div class="h-full min-h-0 min-w-0"><div class="h-full min-h-0 min-w-0"><div class="border border-token-border-light border-radius-3xl corner-superellipse/1.1 rounded-3xl"><div class="h-full w-full border-radius-3xl bg-token-bg-elevated-secondary corner-superellipse/1.1 overflow-clip rounded-3xl lxnfua_clipPathFallback"><div class="pointer-events-none absolute inset-x-4 top-12 bottom-4"><div class="pointer-events-none sticky z-40 shrink-0 z-1!"><div class="sticky bg-token-border-light"></div></div></div><div class=""><div class="relative z-0 flex max-w-full"><div id="code-block-viewer" dir="ltr" class="q9tKkq_viewer cm-editor z-10 light:cm-light dark:cm-light flex h-full w-full flex-col items-stretch ͼk ͼy"><div class="cm-scroller"><div class="cm-content q9tKkq_readonly"><span class="ͼs">cd</span><span> Inmueble</span><br/><span>./mvnw spring-boot:run</span></div></div></div></div></div></div></div></div></div><div class=""><div class=""></div></div></div></div></div></pre>

### Windows

<pre class="overflow-visible! px-0!" data-start="3230" data-end="3286"><div class="relative w-full my-4"><div class=""><div class="relative"><div class="h-full min-h-0 min-w-0"><div class="h-full min-h-0 min-w-0"><div class="border border-token-border-light border-radius-3xl corner-superellipse/1.1 rounded-3xl"><div class="h-full w-full border-radius-3xl bg-token-bg-elevated-secondary corner-superellipse/1.1 overflow-clip rounded-3xl lxnfua_clipPathFallback"><div class="pointer-events-none absolute inset-x-4 top-12 bottom-4"><div class="pointer-events-none sticky z-40 shrink-0 z-1!"><div class="sticky bg-token-border-light"></div></div></div><div class=""><div class="relative z-0 flex max-w-full"><div id="code-block-viewer" dir="ltr" class="q9tKkq_viewer cm-editor z-10 light:cm-light dark:cm-light flex h-full w-full flex-col items-stretch ͼk ͼy"><div class="cm-scroller"><div class="cm-content q9tKkq_readonly"><span class="ͼs">cd</span><span></span><span class="ͼt">Inmueble</span><br/><span>.\</span><span class="ͼt">mvnw</span><span>.</span><span class="ͼt">cmd</span><span></span><span class="ͼt">spring-boot</span><span class="ͼn">:</span><span class="ͼt">run</span></div></div></div></div></div></div></div></div></div><div class=""><div class=""></div></div></div></div></div></pre>

---

# Flujo de prueba rápido (Postman)

## 1. Login staff

`POST http://localhost:8081/api/v1/auth/login`

<pre class="overflow-visible! px-0!" data-start="3396" data-end="3475"><div class="relative w-full my-4"><div class=""><div class="relative"><div class="h-full min-h-0 min-w-0"><div class="h-full min-h-0 min-w-0"><div class="border border-token-border-light border-radius-3xl corner-superellipse/1.1 rounded-3xl"><div class="h-full w-full border-radius-3xl bg-token-bg-elevated-secondary corner-superellipse/1.1 overflow-clip rounded-3xl lxnfua_clipPathFallback"><div class="pointer-events-none absolute inset-x-4 top-12 bottom-4"><div class="pointer-events-none sticky z-40 shrink-0 z-1!"><div class="sticky bg-token-border-light"></div></div></div><div class=""><div class="relative z-0 flex max-w-full"><div id="code-block-viewer" dir="ltr" class="q9tKkq_viewer cm-editor z-10 light:cm-light dark:cm-light flex h-full w-full flex-col items-stretch ͼk ͼy"><div class="cm-scroller"><div class="cm-content q9tKkq_readonly"><span>{</span><br/><span>  "email": </span><span class="ͼr">"admin@inmobiliaria.com"</span><span>,</span><br/><span>  "password": </span><span class="ͼr">"Admin1234!"</span><br/><span>}</span></div></div></div></div></div></div></div></div></div><div class=""><div class=""></div></div></div></div></div></pre>

Copiar el token devuelto en la respuesta.

---

## 2. Consultar catálogo público

`GET http://localhost:8080/casa`

No requiere autenticación.

---

## 3. Probar endpoints protegido con token de login de staff

`POST http://localhost:8080/casa`

<pre class="overflow-visible! px-0!" data-start="3396" data-end="3475"><div class="relative w-full my-4"><div class=""><div class="relative"><div class="h-full min-h-0 min-w-0"><div class="h-full min-h-0 min-w-0"><div class="border border-token-border-light border-radius-3xl corner-superellipse/1.1 rounded-3xl"><div class="h-full w-full border-radius-3xl bg-token-bg-elevated-secondary corner-superellipse/1.1 overflow-clip rounded-3xl lxnfua_clipPathFallback"><div class="pointer-events-none absolute inset-x-4 top-12 bottom-4"><div class="pointer-events-none sticky z-40 shrink-0 z-1!"><div class="sticky bg-token-border-light"></div></div></div><div class=""><div class="relative z-0 flex max-w-full"><div id="code-block-viewer" dir="ltr" class="q9tKkq_viewer cm-editor z-10 light:cm-light dark:cm-light flex h-full w-full flex-col items-stretch ͼk ͼy"><div class="cm-scroller"><div class="cm-content q9tKkq_readonly"><span>{
  "direccion": "Islas 888",
  "precio": 399999,
  "disponible": true,
  "operacion": "ALQUILER",
  "fechaPublicacion": "2025-06-02",
  "dormitorios": 4,
  "banios": 3,
  "garage": 2,
  "area": 200,
  "tamanioLote": 400
}</span></div></div></div></div></div></div></div></div></div><div class=""><div class=""></div></div></div></div></div></pre>

Header requerido:

<pre class="overflow-visible! px-0!" data-start="3713" data-end="3750"><div class="relative w-full my-4"><div class=""><div class="relative"><div class="h-full min-h-0 min-w-0"><div class="h-full min-h-0 min-w-0"><div class="border border-token-border-light border-radius-3xl corner-superellipse/1.1 rounded-3xl"><div class="h-full w-full border-radius-3xl bg-token-bg-elevated-secondary corner-superellipse/1.1 overflow-clip rounded-3xl lxnfua_clipPathFallback"><div class="pointer-events-none absolute inset-x-4 top-12 bottom-4"><div class="pointer-events-none sticky z-40 shrink-0 z-1!"><div class="sticky bg-token-border-light"></div></div></div><div class=""><div class="relative z-0 flex max-w-full"><div id="code-block-viewer" dir="ltr" class="q9tKkq_viewer cm-editor z-10 light:cm-light dark:cm-light flex h-full w-full flex-col items-stretch ͼk ͼy"><div class="cm-scroller"><div class="cm-content q9tKkq_readonly"><span>Authorization: Bearer <token></span></div></div></div></div></div></div></div></div></div><div class=""><div class=""></div></div></div></div></div></pre>



`GET http://localhost:8080/api/v1/admin/leads`

Header requerido:

<pre class="overflow-visible! px-0!" data-start="3713" data-end="3750"><div class="relative w-full my-4"><div class=""><div class="relative"><div class="h-full min-h-0 min-w-0"><div class="h-full min-h-0 min-w-0"><div class="border border-token-border-light border-radius-3xl corner-superellipse/1.1 rounded-3xl"><div class="h-full w-full border-radius-3xl bg-token-bg-elevated-secondary corner-superellipse/1.1 overflow-clip rounded-3xl lxnfua_clipPathFallback"><div class="pointer-events-none absolute inset-x-4 top-12 bottom-4"><div class="pointer-events-none sticky z-40 shrink-0 z-1!"><div class="sticky bg-token-border-light"></div></div></div><div class=""><div class="relative z-0 flex max-w-full"><div id="code-block-viewer" dir="ltr" class="q9tKkq_viewer cm-editor z-10 light:cm-light dark:cm-light flex h-full w-full flex-col items-stretch ͼk ͼy"><div class="cm-scroller"><div class="cm-content q9tKkq_readonly"><span>Authorization: Bearer <token></span></div></div></div></div></div></div></div></div></div><div class=""><div class=""></div></div></div></div></div></pre>

---

# 4. Crear Lead (Interesado)

`POST http://localhost:8080/api/v1/leads`

<pre class="overflow-visible! px-0!" data-start="3396" data-end="3475"><div class="relative w-full my-4"><div class=""><div class="relative"><div class="h-full min-h-0 min-w-0"><div class="h-full min-h-0 min-w-0"><div class="border border-token-border-light border-radius-3xl corner-superellipse/1.1 rounded-3xl"><div class="h-full w-full border-radius-3xl bg-token-bg-elevated-secondary corner-superellipse/1.1 overflow-clip rounded-3xl lxnfua_clipPathFallback"><div class="pointer-events-none absolute inset-x-4 top-12 bottom-4"><div class="pointer-events-none sticky z-40 shrink-0 z-1!"><div class="sticky bg-token-border-light"></div></div></div><div class=""><div class="relative z-0 flex max-w-full"><div id="code-block-viewer" dir="ltr" class="q9tKkq_viewer cm-editor z-10 light:cm-light dark:cm-light flex h-full w-full flex-col items-stretch ͼk ͼy"><div class="cm-scroller"><div class="cm-content q9tKkq_readonly"><span>{
  "inmuebleId": 11,
  "nombre": "Arturo Perez",
  "email": "arturoperez@gmail.com",
  "telefono": "+541122334411",
  "mensaje": "Me interesa este departamento. Quiero Alquilarlo!"
}</span></div></div></div></div></div></div></div></div></div><div class=""><div class=""></div></div></div></div></div></pre>

No requiere autenticación.

---

# Estado actual y próximos pasos

* Consolidar contratos de API (DTOs y manejo uniforme de errores).
* Implementar búsqueda unificada con filtros y paginación.
* Incorporar módulo de leads/contacto desde publicaciones.
* Fortalecer tests de seguridad e integración.
* Incorporar CI/CD.
* Agregar observabilidad y despliegue reproducible.
* Evolucionar a base de datos productiva (PostgreSQL o MySQL).
* Desarrollar frontend público y panel inmobiliario.
