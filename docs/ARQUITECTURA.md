# Arquitectura de TaskFlow

Este documento orienta a un desarrollador nuevo sobre la arquitectura del proyecto TaskFlow: capas, paquetes, flujo de la petición `POST /projects/{projectId}/tasks`, ubicación de las reglas de negocio, seguridad JWT y organización de tests.

## Visión general

- Paquete raíz: `com.taskflow`.
- Capas (de arriba abajo):
  - `controller` — controladores HTTP que exponen la API y validan DTOs.
  - `service` — casos de uso y orquestación de reglas de negocio (ej.: `TaskService`).
  - `repository` — Spring Data JPA (ej.: `TaskRepository`, `ProjectRepository`).
  - `model` — entidades ricas en comportamiento (ej.: `Task`).
  - `dto` / `mapper` — DTOs (como `record`) y mapeadores (ej.: `TaskMapper`).

Ficheros típicos:
- `src/main/java/com/taskflow/controller/TaskController.java`
- `src/main/java/com/taskflow/service/TaskService.java`
- `src/main/java/com/taskflow/repository/TaskRepository.java`
- `src/main/java/com/taskflow/model/Task.java`
- `src/main/java/com/taskflow/mapper/TaskMapper.java`

## Recorrido de `POST /projects/{projectId}/tasks`

Descripción paso a paso exactamente como en el código:

1. Petición HTTP
   - Cliente hace `POST /projects/{projectId}/tasks` con body JSON que cumple el contrato `TaskRequest`.
   - `TaskController` (`src/main/java/com/taskflow/controller/TaskController.java`) recibe la petición.

2. Validación y comprobación del proyecto
   - Spring valida el `@Valid @RequestBody TaskRequest` (Bean Validation). Si falla, el `GlobalExceptionHandler` (`src/main/java/com/taskflow/advice/GlobalExceptionHandler.java`) responde 400.
   - `TaskController.createTask` llama a `ProjectService.buscarPorId(projectId)` y, si el proyecto no existe, lanza `ProjectNotFoundException` (404).

3. Conversión y creación
   - `TaskController` invoca `TaskService.crear(request, projectId)`.
   - `TaskService.crear` convierte el DTO a entidad nueva usando `TaskMapper.aEntidadNueva(request, projectId)` (que pasa por la factory de negocio `Task.crear`) y luego persiste con `TaskRepository.save(nueva)`.

4. Respuesta HTTP
   - Después de guardar, `TaskController` construye la cabecera `Location` apuntando a `/tasks/{id}` y responde `201 Created` con el body obtenido mediante `TaskMapper.aResponse(creada)`.

Notas rápidas de responsabilidades (coinciden con el código):
- `TaskController`: valida entrada y comprueba existencia del proyecto (`ProjectService.buscarPorId`), construye la respuesta HTTP.
- `TaskService`: convierte el `TaskRequest` a entidad con `TaskMapper.aEntidadNueva` y delega la persistencia a `TaskRepository.save`.
- `TaskMapper`: puente DTO↔Entidad; `aEntidadNueva` usa `Task.crear` y `aResponse` crea el `TaskResponse`.


## Dónde viven las reglas de negocio

- Reglas de bajo nivel y invariantes de entidad: dentro de `src/main/java/com/taskflow/model/Task.java` (métodos como `crear`, `estaVencida`, transiciones de estado).
- Reglas de orquestación (ej.: "el project debe existir", "solo el owner o ADMIN puede borrar project") en `src/main/java/com/taskflow/service/*` (ej.: `TaskService`, `ProjectService`).
- Reglas de seguridad por recurso (ej.: borrado de proyecto) se hacen con `@PreAuthorize` y lógica en `src/main/java/com/taskflow/security/ProjectSecurity.java`.
- Evitar duplicar lógica: el servicio debe delegar a métodos de entidad cuando corresponda.

## Seguridad: JWT

- Autenticación sin estado con JWT. Componentes principales:
  - `src/main/java/com/taskflow/security/JwtService.java` — creación y verificación de tokens, firma y expiración.
  - `src/main/java/com/taskflow/security/JwtAuthenticationFilter.java` — filtro que intercepta `Authorization: Bearer <token>`, valida el token y llena el `SecurityContext`.
  - `src/main/java/com/taskflow/config/SecurityConfig.java` — configuración de Spring Security: rutas públicas y protegidas.

- Endpoints públicos (según convención del proyecto):
  - `POST /auth/**` (login/token)
  - `GET /info`
  - Swagger UI y recursos estáticos en `src/main/resources/static`
  - Consola H2 (cuando habilitada)

- Flujo de token:
  1. Usuario hace login en `POST /auth/login` y recibe un JWT con `username` y `roles`.
  2. Cliente incluye `Authorization: Bearer <token>` en peticiones subsecuentes.
  3. `JwtAuthenticationFilter` valida firma y expira y, si válido, construye una `UsernamePasswordAuthenticationToken` con roles y la coloca en `SecurityContextHolder`.
  4. Las anotaciones `@PreAuthorize` (y `ProjectSecurity`) usan ese contexto para autorizar acciones.

- Tokens son `stateless`: ninguna sesión en servidor. Revocación requiere estrategia adicional (blacklist, short-lived tokens + refresh, etc.).

## Organización de tests

Convenciones y comandos (ver README y las instrucciones del repo):

- Comando comúnes:
  - `mvn -q test` — suite normal (unit y slice); no ejecuta `*IT.java` que usan Testcontainers salvo que se active `-Ddocker.tests=true`.
  - `mvn -q test "-Dtest=TaskServiceTest"` — ejecutar una clase concreta.
  - `mvn spring-boot:run "-Dspring-boot.run.profiles=h2"` — correr app con H2 en memoria y `DataSeeder`.

- Tipos de tests:
  - Unit (rápidos): JUnit 5 + Mockito, sin Spring. Carpeta: `src/test/java/com/taskflow/unit` (ej.: `TaskServiceTest`).
  - Slice: `@WebMvcTest` para controladores o `@DataJpaTest` para repositorios. Aísla dependencias de Spring.
  - Integration: `@SpringBootTest` con profile `test`. Tests que terminan en `*IT.java` usan Testcontainers y requieren `-Ddocker.tests=true` para ejecutarse esta semana.

- Datos de prueba y seeding:
  - `DataSeeder` (ej.: `src/main/java/com/taskflow/config/DataSeeder.java`) rellena la BD con usuarios `ana`, `luis`, `admin` y datos de ejemplo cuando se usa el perfil `h2`.

- Reglas de las pruebas:
  - No modificar tests existentes para que pasen; si fallan, arreglar código o explicar por qué.
  - Tests unitarios no deben arrancar el contexto completo de Spring.

## Puntos prácticos y convenciones importantes

- DTOs como `record` con validación (`@NotNull`, `@Size`, etc.).
- Inyección por constructor y sin Lombok.
- Respuestas: `POST` crea → `201 Created` + `Location`; `DELETE` → `204 No Content`.
- Control central de errores: `src/main/java/com/taskflow/advice/GlobalExceptionHandler.java` convierte excepciones en códigos HTTP uniformes (400, 401, 403, 404, 409, 422 según el caso).
- Seguridad: borrado de proyectos sólo owner o `ADMIN` (combinación de `@PreAuthorize` y `ProjectSecurity`).
- UI estática servida desde `src/main/resources/static`.

## Dónde mirar primero en el código

- Para entender la API y los DTOs: `src/main/java/com/taskflow/controller/TaskController.java` y `src/main/java/com/taskflow/mapper/TaskMapper.java`.
- Para reglas de negocio: `src/main/java/com/taskflow/model/Task.java`.
- Para orquestación y permisos: `src/main/java/com/taskflow/service/TaskService.java` y `src/main/java/com/taskflow/security/ProjectSecurity.java`.
- Para seguridad JWT: `src/main/java/com/taskflow/security/JwtService.java` y `src/main/java/com/taskflow/security/JwtAuthenticationFilter.java`.
- Para excepciones y respuestas uniformes: `src/main/java/com/taskflow/advice/GlobalExceptionHandler.java`.

---

Si se requiere, se puede ampliar con diagramas de flujo, ejemplos de petición/respuesta JSON y fragmentos de código. Solicitar específicamente qué ampliar (por ejemplo: flujo de creación de token, ejemplos de tests unitarios o integración).Las fechas límite se validan en `Task.crear` (`src/main/java/com/taskflow/model/Task.java`).
