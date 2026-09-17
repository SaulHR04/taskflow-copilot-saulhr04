# Copilot CLI Session

> [!NOTE]
> - **Session ID:** `a669a4fb-d335-4f3a-ba0f-f20671221a78`  
> - **Started:** 16/9/2026, 8:53:41 p.m.  
> - **Duration:** 1m 35s  
> - **Exported:** 16/9/2026, 8:55:16 p.m.  

---

<sub>1s</sub>

### User

Revisa evidencia/dia4/summary.diff contra la especificación specs/summary.md.

---

<sub>8s</sub>

### Copilot

Voy a abrir el diff y la especificación para compararlos archivo por archivo y luego revisar el diff contra la checklist (alcance, tests, reglas de dominio, contrato, convenciones, comentarios, tests útiles). Abriendo evidence/dia4/summary.diff y specs/summary.md para empezar la revisión.

---

<sub>8s</sub>

### `view` — Failed

**view the file at C:\Users\Saul\taskflow-copilot-\evidence\dia4\summary.diff.**

C:\Users\Saul\taskflow-copilot-\evidence\dia4\summary.diff

```
Path does not exist
```


---

<sub>8s</sub>

### `view`

**view the file at C:\Users\Saul\taskflow-copilot-\specs\summary.md.**

C:\Users\Saul\taskflow-copilot-\specs\summary.md

<details>
<summary>52 lines</summary>

````
## Qué se pide

Un endpoint nuevo, `GET /projects/{id}/summary`, que resume un proyecto: **cuántas tareas tiene en
cada estado y cuántas están vencidas**. Sirve para pintar un tablero sin descargar todas las tareas del
proyecto. Pide el token de `POST /auth/login`, como todo lo que no es público.

## Respuesta 200

```json
{
  "projectId": 2,
  "projectName": "App Móvil",
  "totalTasks": 4,
  "byStatus": { "TODO": 1, "IN_PROGRESS": 2, "DONE": 1 },
  "overdue": 1
}
```

| Campo | Tipo | Qué es |
|---|---|---|
| `projectId` | número | el `id` del proyecto pedido |
| `projectName` | texto | el `name` del proyecto |
| `totalTasks` | número | cuántas tareas tiene el proyecto |
| `byStatus` | objeto | una clave por cada valor de `TaskStatus` (`TODO`, `IN_PROGRESS`, `DONE`), **siempre las tres**, aunque valgan 0 |
| `overdue` | número | cuántas tareas del proyecto cumplen `Task.estaVencida()` |

## Reglas

1. **Vencida** es exactamente lo que ya dice `Task.estaVencida()`: tiene fecha límite, la fecha ya pasó y
   el estado no es `DONE`. Se reutiliza ese método; no se reescribe la regla en el servicio.
2. Un proyecto **sin tareas** responde 200 con `totalTasks` 0, las tres claves de `byStatus` en 0 y `overdue` 0.
3. Un proyecto **que no existe** responde **404** con el `ErrorResponse` uniforme de siempre
   (`ProjectNotFoundException`, igual que `GET /projects/{id}`).
4. **Sin token** responde **401**, como todo lo que no es público.
5. Cualquier usuario autenticado puede pedir el resumen de cualquier proyecto (igual que `GET /projects/{id}/tasks`).

## Resultado esperado con la semilla del perfil `h2`

| Petición | `totalTasks` | `byStatus` | `overdue` |
|---|---|---|---|
| `GET /projects/1/summary` | 5 | `TODO` 3 · `IN_PROGRESS` 1 · `DONE` 1 | 0 (la tarea 2 tiene fecha pasada, pero está `DONE`) |
| `GET /projects/2/summary` | 4 | `TODO` 1 · `IN_PROGRESS` 2 · `DONE` 1 | 1 (la tarea 7) |
| `GET /projects/3/summary` | 0 | `TODO` 0 · `IN_PROGRESS` 0 · `DONE` 0 | 0 |
| `GET /projects/99/summary` | — | — | 404 |

Si antes de probar creaste tareas en un proyecto (por la UI o con el servidor MCP), `totalTasks` y
`TODO` de ese proyecto suben en la misma cantidad. Al reiniciar la app con el perfil `h2` vuelven a
ser los de la tabla.

## Cómo se construye (convenciones de TaskFlow)

- DTO de salida: un `record` en `com.taskflow.dto`, `ProjectSummaryResponse`.
- La lógica de conteo va en el servicio (`ProjectService`), no en el controller.
- El controller solo traduce HTTP: busca el proyecto (404 si no existe) y delega.
- Tests:
  - **unit** del servicio con Mockito: un proyecto con tareas en los tres estados y una vencida; un proyecto sin tareas.
  - **slice** `@WebMvcTest` del controller: 200 con el JSON de arriba y 404 con un proyecto inexistente.
- `mvn -q test` en verde al terminar, sin modificar tests existentes.

## Criterios de aceptación

- [ ] `GET /projects/2/summary` con el token de `ana` devuelve el JSON del ejemplo.
- [ ] `GET /projects/3/summary` devuelve ceros en los cinco números.
- [ ] `GET /projects/99/summary` devuelve 404.
- [ ] `mvn -q test` en verde: los tests de antes más los nuevos.
````

</details>


---

<sub>14s</sub>

### Copilot

Abriendo el diff y la especificación para comparar archivos y luego aplicar la checklist del revisor. Ejecutando lecturas de evidence/dia4 y specs/summary.md en paralelo.

---

<sub>14s</sub>

### `view` — Failed

**view the file at C:\Users\Saul\taskflow-copilot-\evidence\dia4.**

C:\Users\Saul\taskflow-copilot-\evidence\dia4

```
Path does not exist
```


---

<sub>14s</sub>

### `view`

**view the file at C:\Users\Saul\taskflow-copilot-\specs\summary.md.**

C:\Users\Saul\taskflow-copilot-\specs\summary.md

<details>
<summary>52 lines</summary>

````
## Qué se pide

Un endpoint nuevo, `GET /projects/{id}/summary`, que resume un proyecto: **cuántas tareas tiene en
cada estado y cuántas están vencidas**. Sirve para pintar un tablero sin descargar todas las tareas del
proyecto. Pide el token de `POST /auth/login`, como todo lo que no es público.

## Respuesta 200

```json
{
  "projectId": 2,
  "projectName": "App Móvil",
  "totalTasks": 4,
  "byStatus": { "TODO": 1, "IN_PROGRESS": 2, "DONE": 1 },
  "overdue": 1
}
```

| Campo | Tipo | Qué es |
|---|---|---|
| `projectId` | número | el `id` del proyecto pedido |
| `projectName` | texto | el `name` del proyecto |
| `totalTasks` | número | cuántas tareas tiene el proyecto |
| `byStatus` | objeto | una clave por cada valor de `TaskStatus` (`TODO`, `IN_PROGRESS`, `DONE`), **siempre las tres**, aunque valgan 0 |
| `overdue` | número | cuántas tareas del proyecto cumplen `Task.estaVencida()` |

## Reglas

1. **Vencida** es exactamente lo que ya dice `Task.estaVencida()`: tiene fecha límite, la fecha ya pasó y
   el estado no es `DONE`. Se reutiliza ese método; no se reescribe la regla en el servicio.
2. Un proyecto **sin tareas** responde 200 con `totalTasks` 0, las tres claves de `byStatus` en 0 y `overdue` 0.
3. Un proyecto **que no existe** responde **404** con el `ErrorResponse` uniforme de siempre
   (`ProjectNotFoundException`, igual que `GET /projects/{id}`).
4. **Sin token** responde **401**, como todo lo que no es público.
5. Cualquier usuario autenticado puede pedir el resumen de cualquier proyecto (igual que `GET /projects/{id}/tasks`).

## Resultado esperado con la semilla del perfil `h2`

| Petición | `totalTasks` | `byStatus` | `overdue` |
|---|---|---|---|
| `GET /projects/1/summary` | 5 | `TODO` 3 · `IN_PROGRESS` 1 · `DONE` 1 | 0 (la tarea 2 tiene fecha pasada, pero está `DONE`) |
| `GET /projects/2/summary` | 4 | `TODO` 1 · `IN_PROGRESS` 2 · `DONE` 1 | 1 (la tarea 7) |
| `GET /projects/3/summary` | 0 | `TODO` 0 · `IN_PROGRESS` 0 · `DONE` 0 | 0 |
| `GET /projects/99/summary` | — | — | 404 |

Si antes de probar creaste tareas en un proyecto (por la UI o con el servidor MCP), `totalTasks` y
`TODO` de ese proyecto suben en la misma cantidad. Al reiniciar la app con el perfil `h2` vuelven a
ser los de la tabla.

## Cómo se construye (convenciones de TaskFlow)

- DTO de salida: un `record` en `com.taskflow.dto`, `ProjectSummaryResponse`.
- La lógica de conteo va en el servicio (`ProjectService`), no en el controller.
- El controller solo traduce HTTP: busca el proyecto (404 si no existe) y delega.
- Tests:
  - **unit** del servicio con Mockito: un proyecto con tareas en los tres estados y una vencida; un proyecto sin tareas.
  - **slice** `@WebMvcTest` del controller: 200 con el JSON de arriba y 404 con un proyecto inexistente.
- `mvn -q test` en verde al terminar, sin modificar tests existentes.

## Criterios de aceptación

- [ ] `GET /projects/2/summary` con el token de `ana` devuelve el JSON del ejemplo.
- [ ] `GET /projects/3/summary` devuelve ceros en los cinco números.
- [ ] `GET /projects/99/summary` devuelve 404.
- [ ] `mvn -q test` en verde: los tests de antes más los nuevos.
````

</details>


---

<sub>20s</sub>

### Copilot

List the evidence directory to find the diff and open specs/summary.md to compare contents. Running two parallel reads: directory listing of evidence and file view of the spec.

---

<sub>20s</sub>

### `view` — Failed

**view the file at C:\Users\Saul\taskflow-copilot-\evidence.**

C:\Users\Saul\taskflow-copilot-\evidence

```
Path does not exist
```


---

<sub>20s</sub>

### `view`

**view the file at C:\Users\Saul\taskflow-copilot-\specs\summary.md.**

C:\Users\Saul\taskflow-copilot-\specs\summary.md

<details>
<summary>52 lines</summary>

````
## Qué se pide

Un endpoint nuevo, `GET /projects/{id}/summary`, que resume un proyecto: **cuántas tareas tiene en
cada estado y cuántas están vencidas**. Sirve para pintar un tablero sin descargar todas las tareas del
proyecto. Pide el token de `POST /auth/login`, como todo lo que no es público.

## Respuesta 200

```json
{
  "projectId": 2,
  "projectName": "App Móvil",
  "totalTasks": 4,
  "byStatus": { "TODO": 1, "IN_PROGRESS": 2, "DONE": 1 },
  "overdue": 1
}
```

| Campo | Tipo | Qué es |
|---|---|---|
| `projectId` | número | el `id` del proyecto pedido |
| `projectName` | texto | el `name` del proyecto |
| `totalTasks` | número | cuántas tareas tiene el proyecto |
| `byStatus` | objeto | una clave por cada valor de `TaskStatus` (`TODO`, `IN_PROGRESS`, `DONE`), **siempre las tres**, aunque valgan 0 |
| `overdue` | número | cuántas tareas del proyecto cumplen `Task.estaVencida()` |

## Reglas

1. **Vencida** es exactamente lo que ya dice `Task.estaVencida()`: tiene fecha límite, la fecha ya pasó y
   el estado no es `DONE`. Se reutiliza ese método; no se reescribe la regla en el servicio.
2. Un proyecto **sin tareas** responde 200 con `totalTasks` 0, las tres claves de `byStatus` en 0 y `overdue` 0.
3. Un proyecto **que no existe** responde **404** con el `ErrorResponse` uniforme de siempre
   (`ProjectNotFoundException`, igual que `GET /projects/{id}`).
4. **Sin token** responde **401**, como todo lo que no es público.
5. Cualquier usuario autenticado puede pedir el resumen de cualquier proyecto (igual que `GET /projects/{id}/tasks`).

## Resultado esperado con la semilla del perfil `h2`

| Petición | `totalTasks` | `byStatus` | `overdue` |
|---|---|---|---|
| `GET /projects/1/summary` | 5 | `TODO` 3 · `IN_PROGRESS` 1 · `DONE` 1 | 0 (la tarea 2 tiene fecha pasada, pero está `DONE`) |
| `GET /projects/2/summary` | 4 | `TODO` 1 · `IN_PROGRESS` 2 · `DONE` 1 | 1 (la tarea 7) |
| `GET /projects/3/summary` | 0 | `TODO` 0 · `IN_PROGRESS` 0 · `DONE` 0 | 0 |
| `GET /projects/99/summary` | — | — | 404 |

Si antes de probar creaste tareas en un proyecto (por la UI o con el servidor MCP), `totalTasks` y
`TODO` de ese proyecto suben en la misma cantidad. Al reiniciar la app con el perfil `h2` vuelven a
ser los de la tabla.

## Cómo se construye (convenciones de TaskFlow)

- DTO de salida: un `record` en `com.taskflow.dto`, `ProjectSummaryResponse`.
- La lógica de conteo va en el servicio (`ProjectService`), no en el controller.
- El controller solo traduce HTTP: busca el proyecto (404 si no existe) y delega.
- Tests:
  - **unit** del servicio con Mockito: un proyecto con tareas en los tres estados y una vencida; un proyecto sin tareas.
  - **slice** `@WebMvcTest` del controller: 200 con el JSON de arriba y 404 con un proyecto inexistente.
- `mvn -q test` en verde al terminar, sin modificar tests existentes.

## Criterios de aceptación

- [ ] `GET /projects/2/summary` con el token de `ana` devuelve el JSON del ejemplo.
- [ ] `GET /projects/3/summary` devuelve ceros en los cinco números.
- [ ] `GET /projects/99/summary` devuelve 404.
- [ ] `mvn -q test` en verde: los tests de antes más los nuevos.
````

</details>


---

<sub>26s</sub>

### Copilot

Listing repository root to locate the evidence diff and opening the spec for context.

---

<sub>26s</sub>

### `view`

**view the file at C:\Users\Saul\taskflow-copilot-\.**

C:\Users\Saul\taskflow-copilot-\

<details>
<summary>22 lines</summary>

```
.classpath
.dockerignore
.env.example
.git
.gitattributes
.github
.gitignore
.project
.settings
Capturas
Dockerfile
README.md
docker-compose.yml
docs
evidencia
issues
pom.xml
postman
specs
src
target
taskflow-mcp
```

</details>


---

<sub>32s</sub>

### Copilot

Abriré el diff en evidencia/dia4/summary.diff y la especificación specs/summary.md en paralelo para comparar cambios y aplicar la checklist del revisor (alcance, tests, dominio, contrato, convenciones). Ejecutando lecturas en paralelo.

---

<sub>32s</sub>

### `view`

**view the file at C:\Users\Saul\taskflow-copilot-\evidencia\dia4\summary.diff.**

C:\Users\Saul\taskflow-copilot-\evidencia\dia4\summary.diff

```
File too large to read at once (27.0 KB). Consider using the grep tool to search within the file, or view with view_range to read specific sections.
```


---

<sub>32s</sub>

### `view`

**view the file at C:\Users\Saul\taskflow-copilot-\specs\summary.md.**

C:\Users\Saul\taskflow-copilot-\specs\summary.md

<details>
<summary>52 lines</summary>

````
## Qué se pide

Un endpoint nuevo, `GET /projects/{id}/summary`, que resume un proyecto: **cuántas tareas tiene en
cada estado y cuántas están vencidas**. Sirve para pintar un tablero sin descargar todas las tareas del
proyecto. Pide el token de `POST /auth/login`, como todo lo que no es público.

## Respuesta 200

```json
{
  "projectId": 2,
  "projectName": "App Móvil",
  "totalTasks": 4,
  "byStatus": { "TODO": 1, "IN_PROGRESS": 2, "DONE": 1 },
  "overdue": 1
}
```

| Campo | Tipo | Qué es |
|---|---|---|
| `projectId` | número | el `id` del proyecto pedido |
| `projectName` | texto | el `name` del proyecto |
| `totalTasks` | número | cuántas tareas tiene el proyecto |
| `byStatus` | objeto | una clave por cada valor de `TaskStatus` (`TODO`, `IN_PROGRESS`, `DONE`), **siempre las tres**, aunque valgan 0 |
| `overdue` | número | cuántas tareas del proyecto cumplen `Task.estaVencida()` |

## Reglas

1. **Vencida** es exactamente lo que ya dice `Task.estaVencida()`: tiene fecha límite, la fecha ya pasó y
   el estado no es `DONE`. Se reutiliza ese método; no se reescribe la regla en el servicio.
2. Un proyecto **sin tareas** responde 200 con `totalTasks` 0, las tres claves de `byStatus` en 0 y `overdue` 0.
3. Un proyecto **que no existe** responde **404** con el `ErrorResponse` uniforme de siempre
   (`ProjectNotFoundException`, igual que `GET /projects/{id}`).
4. **Sin token** responde **401**, como todo lo que no es público.
5. Cualquier usuario autenticado puede pedir el resumen de cualquier proyecto (igual que `GET /projects/{id}/tasks`).

## Resultado esperado con la semilla del perfil `h2`

| Petición | `totalTasks` | `byStatus` | `overdue` |
|---|---|---|---|
| `GET /projects/1/summary` | 5 | `TODO` 3 · `IN_PROGRESS` 1 · `DONE` 1 | 0 (la tarea 2 tiene fecha pasada, pero está `DONE`) |
| `GET /projects/2/summary` | 4 | `TODO` 1 · `IN_PROGRESS` 2 · `DONE` 1 | 1 (la tarea 7) |
| `GET /projects/3/summary` | 0 | `TODO` 0 · `IN_PROGRESS` 0 · `DONE` 0 | 0 |
| `GET /projects/99/summary` | — | — | 404 |

Si antes de probar creaste tareas en un proyecto (por la UI o con el servidor MCP), `totalTasks` y
`TODO` de ese proyecto suben en la misma cantidad. Al reiniciar la app con el perfil `h2` vuelven a
ser los de la tabla.

## Cómo se construye (convenciones de TaskFlow)

- DTO de salida: un `record` en `com.taskflow.dto`, `ProjectSummaryResponse`.
- La lógica de conteo va en el servicio (`ProjectService`), no en el controller.
- El controller solo traduce HTTP: busca el proyecto (404 si no existe) y delega.
- Tests:
  - **unit** del servicio con Mockito: un proyecto con tareas en los tres estados y una vencida; un proyecto sin tareas.
  - **slice** `@WebMvcTest` del controller: 200 con el JSON de arriba y 404 con un proyecto inexistente.
- `mvn -q test` en verde al terminar, sin modificar tests existentes.

## Criterios de aceptación

- [ ] `GET /projects/2/summary` con el token de `ana` devuelve el JSON del ejemplo.
- [ ] `GET /projects/3/summary` devuelve ceros en los cinco números.
- [ ] `GET /projects/99/summary` devuelve 404.
- [ ] `mvn -q test` en verde: los tests de antes más los nuevos.
````

</details>


---

<sub>39s</sub>

### Copilot

Abriendo el diff evidencia/dia4/summary.diff para listar los archivos modificados y revisar cada uno según la checklist. Luego se abrirán los archivos de producción y tests afectados. Ejecutando lectura.

---

<sub>39s</sub>

### `view`

**view the file at C:\Users\Saul\taskflow-copilot-\evidencia\dia4\summary.diff.**

C:\Users\Saul\taskflow-copilot-\evidencia\dia4\summary.diff

```
File too large to read at once (27.0 KB). Consider using the grep tool to search within the file, or view with view_range to read specific sections.
```


---

<sub>44s</sub>

### Copilot

Leyendo las primeras 400 líneas de evidencia/dia4/summary.diff para obtener la lista de archivos afectados y los cambios principales.

---

<sub>44s</sub>

### `view`

**view the file at C:\Users\Saul\taskflow-copilot-\evidencia\dia4\summary.diff.**

C:\Users\Saul\taskflow-copilot-\evidencia\dia4\summary.diff (lines 1-400)

<details>
<summary>385 lines</summary>

```diff
diff --git a/src/main/java/com/taskflow/controller/ProjectController.java b/src/main/java/com/taskflow/controller/ProjectController.java
index 56ccccf..1048cb7 100644
--- a/src/main/java/com/taskflow/controller/ProjectController.java
+++ b/src/main/java/com/taskflow/controller/ProjectController.java
@@ -66,6 +66,16 @@ public class ProjectController {
         return ProjectMapper.aResponse(proyecto);
     }
 
+    /** GET /projects/{id}/summary — resumen del proyecto (conteos por estado y vencidas). */
+    @Operation(summary = "Resumen de un proyecto",
+            description = "Cuenta tareas por estado (siempre las tres claves) y cuántas están vencidas. 404 si el proyecto no existe.")
+    @GetMapping("/projects/{id}/summary")
+    public com.taskflow.dto.ProjectSummaryResponse getSummary(@PathVariable("id") Long id) {
+        Project proyecto = projectService.buscarPorId(id)
+                .orElseThrow(() -> new ProjectNotFoundException(id));
+        return projectService.resumen(proyecto);
+    }
+
     /**
      * GET /projects/{id}/tasks — las tareas de un proyecto como TaskResponse. Conserva la distinción
      * de D2: proyecto inexistente -> 404 (orElseThrow); proyecto sin tareas -> 200 con []. El filtro
diff --git a/src/main/java/com/taskflow/controller/TaskController.java b/src/main/java/com/taskflow/controller/TaskController.java
index 73e23d4..956cf15 100644
--- a/src/main/java/com/taskflow/controller/TaskController.java
+++ b/src/main/java/com/taskflow/controller/TaskController.java
@@ -72,22 +72,20 @@ public class TaskController {
         return tareas.stream().map(TaskMapper::aResponse).toList();
     }
 
-    /** GET /tasks/overdue — lista tareas vencidas de todos los proyectos. */
+    /** GET /tasks/overdue — tareas vencidas de todos los proyectos, la más vencida primero (S6 Día 2). */
     @Operation(summary = "Lista tareas vencidas",
-            description = "Tareas con dueDate pasado y no DONE, ordenadas por fecha asc.")
+            description = "Tareas con fecha pasada que no están DONE (Task.estaVencida()), por dueDate ascendente.")
     @GetMapping("/tasks/overdue")
-    public List<TaskResponse> getTasksOverdue() {
-        List<Task> tareas = taskService.vencidas();
-        return tareas.stream().map(TaskMapper::aResponse).toList();
+    public List<TaskResponse> getOverdueTasks() {
+        return taskService.vencidas().stream().map(TaskMapper::aResponse).toList();
     }
 
-    /** GET /tasks/unassigned — lista tareas sin responsable de todos los proyectos. */
+    /** GET /tasks/unassigned — tareas sin responsable, por dueDate ascendente y sin fecha al final (S6 Día 2). */
     @Operation(summary = "Lista tareas sin responsable",
-            description = "Tareas cuyo assigneeId es null, ordenadas por dueDate asc (nulls al final).")
+            description = "Tareas con assigneeId null en cualquier estado, por dueDate ascendente; las sin fecha al final.")
     @GetMapping("/tasks/unassigned")
-    public List<TaskResponse> getTasksUnassigned() {
-        List<Task> tareas = taskService.sinResponsable();
-        return tareas.stream().map(TaskMapper::aResponse).toList();
+    public List<TaskResponse> getUnassignedTasks() {
+        return taskService.sinResponsable().stream().map(TaskMapper::aResponse).toList();
     }
 
     /** GET /tasks/{id} — 200 con TaskResponse, o 404 uniforme (orElseThrow -> advice). */
diff --git a/src/main/java/com/taskflow/dto/ProjectSummaryResponse.java b/src/main/java/com/taskflow/dto/ProjectSummaryResponse.java
new file mode 100644
index 0000000..eaa6c6e
--- /dev/null
+++ b/src/main/java/com/taskflow/dto/ProjectSummaryResponse.java
@@ -0,0 +1,15 @@
+package com.taskflow.dto;
+
+import java.util.Map;
+
+/**
+ * ProjectSummaryResponse — contrato de salida de GET /projects/{id}/summary.
+ */
+public record ProjectSummaryResponse(
+        Long projectId,
+        String projectName,
+        long totalTasks,
+        Map<String, Long> byStatus,
+        long overdue
+) {
+}
diff --git a/src/main/java/com/taskflow/mapper/ProjectMapper.java b/src/main/java/com/taskflow/mapper/ProjectMapper.java
index a33a95b..6c2769d 100644
--- a/src/main/java/com/taskflow/mapper/ProjectMapper.java
+++ b/src/main/java/com/taskflow/mapper/ProjectMapper.java
@@ -1,6 +1,7 @@
 package com.taskflow.mapper;
 
 import com.taskflow.dto.ProjectResponse;
+import com.taskflow.dto.ProjectSummaryResponse;
 import com.taskflow.model.Project;
 
 /**
@@ -22,4 +23,11 @@ public final class ProjectMapper {
         return new ProjectResponse(p.getId(), p.getName(), p.getDescription(),
                 p.getOwnerId(), p.getCreatedAt());
     }
+
+    /** Mapea los conteos ya calculados por el service -> DTO de salida de GET /projects/{id}/summary. */
+    public static ProjectSummaryResponse aSummary(Long projectId, String projectName,
+                                                  long totalTasks, java.util.Map<String, Long> byStatus,
+                                                  long overdue) {
+        return new ProjectSummaryResponse(projectId, projectName, totalTasks, byStatus, overdue);
+    }
 }
diff --git a/src/main/java/com/taskflow/service/ProjectService.java b/src/main/java/com/taskflow/service/ProjectService.java
index d315e3f..1421b81 100644
--- a/src/main/java/com/taskflow/service/ProjectService.java
+++ b/src/main/java/com/taskflow/service/ProjectService.java
@@ -30,6 +30,26 @@ import java.util.Optional;
 @Service
 public class ProjectService {
 
+    /**
+     * Resumen de un proyecto: cuenta tareas por estado y vencidas. Recibe el proyecto ya cargado
+     * (el controller decide 404 con buscarPorId). Reutiliza Task.estaVencida() para la regla de
+     * vencido.
+     */
+    public com.taskflow.dto.ProjectSummaryResponse resumen(Project proyecto) {
+        java.util.List<com.taskflow.model.Task> tareas = taskRepository.findByProjectId(proyecto.getId());
+        long total = tareas.size();
+        java.util.Map<String, Long> byStatus = new java.util.HashMap<>();
+        // Inicializar las tres claves a 0 para garantizar presencia aunque no haya tareas
+        for (com.taskflow.model.TaskStatus s : com.taskflow.model.TaskStatus.values()) {
+            byStatus.put(s.name(), 0L);
+        }
+        for (com.taskflow.model.Task t : tareas) {
+            byStatus.put(t.getStatus().name(), byStatus.get(t.getStatus().name()) + 1);
+        }
+        long overdue = tareas.stream().filter(com.taskflow.model.Task::estaVencida).count();
+        return com.taskflow.mapper.ProjectMapper.aSummary(proyecto.getId(), proyecto.getName(), total, byStatus, overdue);
+    }
+
     private final ProjectRepository projectRepository;
     private final TaskRepository taskRepository;
     private final UserRepository userRepository;   // D5: para resolver el owner desde el username del JWT
diff --git a/src/main/java/com/taskflow/service/TaskService.java b/src/main/java/com/taskflow/service/TaskService.java
index 0364b6a..bf18eec 100644
--- a/src/main/java/com/taskflow/service/TaskService.java
+++ b/src/main/java/com/taskflow/service/TaskService.java
@@ -111,19 +111,10 @@ public class TaskService {
                 .toList();
     }
 
-    /** Busca una tarea por id: delega en el repositorio y deja subir el Optional TAL CUAL. */
-    public Optional<Task> buscarPorId(Long id) {
-        return repository.findById(id);
-    }
-
-    /** STRETCH — filtro por prioridad (?priority=): MISMO patrón que porEstado. */
-    public List<Task> porPrioridad(Priority priority) {
-        return repository.findAll().stream()
-                .filter(t -> t.getPriority() == priority)
-                .toList();
-    }
-
-    /** Lista las tareas vencidas (dueDate en el pasado y no DONE), ordenadas por fecha asc (POR_FECHA). */
+    /**
+     * Tareas vencidas de todos los proyectos (GET /tasks/overdue, S6 Día 2). La regla es la del
+     * dominio, Task.estaVencida(); el orden, TaskOrders.POR_FECHA: la más vencida primero.
+     */
     public List<Task> vencidas() {
         return repository.findAll().stream()
                 .filter(Task::estaVencida)
@@ -131,11 +122,27 @@ public class TaskService {
                 .toList();
     }
 
-    /** Lista las tareas sin responsable (assigneeId == null), ordenadas por fecha asc (POR_FECHA). */
+    /**
+     * Tareas sin responsable de todos los proyectos, en cualquier estado (GET /tasks/unassigned, S6
+     * Día 2). La regla es ReportService.SIN_ASIGNAR; el orden, TaskOrders.POR_FECHA: por fecha
+     * ascendente y las que no tienen fecha al final.
+     */
     public List<Task> sinResponsable() {
         return repository.findAll().stream()
                 .filter(ReportService.SIN_ASIGNAR)
                 .sorted(TaskOrders.POR_FECHA)
                 .toList();
     }
+
+    /** Busca una tarea por id: delega en el repositorio y deja subir el Optional TAL CUAL. */
+    public Optional<Task> buscarPorId(Long id) {
+        return repository.findById(id);
+    }
+
+    /** STRETCH — filtro por prioridad (?priority=): MISMO patrón que porEstado. */
+    public List<Task> porPrioridad(Priority priority) {
+        return repository.findAll().stream()
+                .filter(t -> t.getPriority() == priority)
+                .toList();
+    }
 }
diff --git a/src/test/java/com/taskflow/slice/ProjectSummaryControllerTest.java b/src/test/java/com/taskflow/slice/ProjectSummaryControllerTest.java
new file mode 100644
index 0000000..9d1b27f
--- /dev/null
+++ b/src/test/java/com/taskflow/slice/ProjectSummaryControllerTest.java
@@ -0,0 +1,61 @@
+package com.taskflow.slice;
+
+import com.taskflow.controller.ProjectController;
+import com.taskflow.dto.ProjectSummaryResponse;
+import com.taskflow.model.Project;
+import com.taskflow.security.JwtAuthenticationFilter;
+import com.taskflow.service.ProjectService;
+import org.junit.jupiter.api.Test;
+import org.springframework.beans.factory.annotation.Autowired;
+import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
+import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
+import org.springframework.test.context.bean.override.mockito.MockitoBean;
+import org.springframework.test.web.servlet.MockMvc;
+
+import java.util.Optional;
+
+import static org.mockito.ArgumentMatchers.any;
+import static org.mockito.Mockito.when;
+import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
+import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
+import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
+
+@WebMvcTest(ProjectController.class)
+@AutoConfigureMockMvc(addFilters = false)
+class ProjectSummaryControllerTest {
+
+    @Autowired
+    private MockMvc mockMvc;
+
+    @MockitoBean
+    private ProjectService projectService;
+
+    @MockitoBean
+    private JwtAuthenticationFilter jwtAuthenticationFilter;
+
+    @Test
+    void getSummary_existente_devuelve200ConCadaCampo() throws Exception {
+        when(projectService.buscarPorId(2L)).thenReturn(Optional.of(new Project(2L, "App Móvil", "d", 1L, null)));
+        when(projectService.resumen(any(Project.class))).thenReturn(new ProjectSummaryResponse(2L, "App Móvil", 4,
+                java.util.Map.of("TODO", 1L, "IN_PROGRESS", 2L, "DONE", 1L), 1L));
+
+        mockMvc.perform(get("/projects/2/summary"))
+                .andExpect(status().isOk())
+                .andExpect(jsonPath("$.projectId").value(2))
+                .andExpect(jsonPath("$.projectName").value("App Móvil"))
+                .andExpect(jsonPath("$.totalTasks").value(4))
+                .andExpect(jsonPath("$.byStatus.TODO").value(1))
+                .andExpect(jsonPath("$.byStatus.IN_PROGRESS").value(2))
+                .andExpect(jsonPath("$.byStatus.DONE").value(1))
+                .andExpect(jsonPath("$.overdue").value(1));
+    }
+
+    @Test
+    void getSummary_proyectoInexistente_devuelve404() throws Exception {
+        when(projectService.buscarPorId(99L)).thenReturn(Optional.empty());
+
+        mockMvc.perform(get("/projects/99/summary"))
+                .andExpect(status().isNotFound())
+                .andExpect(jsonPath("$.status").value(404));
+    }
+}
diff --git a/src/test/java/com/taskflow/slice/TaskControllerTest.java b/src/test/java/com/taskflow/slice/TaskControllerTest.java
index 89c35f5..4c1439a 100644
--- a/src/test/java/com/taskflow/slice/TaskControllerTest.java
+++ b/src/test/java/com/taskflow/slice/TaskControllerTest.java
@@ -90,47 +90,42 @@ class TaskControllerTest {
                 .andExpect(jsonPath("$[0].title").value("Primera"));
     }
 
+    // ==================== S6 Día 2: listados nuevos ====================
+    // La lista la fija el mock: aquí se prueba que la RUTA llega al método nuevo (200, no el 400 de
+    // /tasks/{id}) y que el JSON trae los campos del TaskResponse. El orden se prueba en TaskServiceTest.
+
     @Test
-    void getTaskPorId_existente_retorna200ConElTitulo() throws Exception {
-        when(taskService.buscarPorId(1L)).thenReturn(Optional.of(tarea(1L, "Diseñar esquema de BD", TaskStatus.TODO)));
+    void getOverdue_retorna200ConLasTareasDelServicio() throws Exception {
+        when(taskService.vencidas()).thenReturn(List.of(
+                tareaConFecha(7L, "Corregir bug de fechas", 2L, LocalDate.now().minusDays(1))));
 
-        mockMvc.perform(get("/tasks/1"))
+        mockMvc.perform(get("/tasks/overdue"))
                 .andExpect(status().isOk())
-                .andExpect(jsonPath("$.title").value("Diseñar esquema de BD"))
-                .andExpect(jsonPath("$.projectId").value(1));
+                .andExpect(jsonPath("$.length()").value(1))
+                .andExpect(jsonPath("$[0].id").value(7))
+                .andExpect(jsonPath("$[0].title").value("Corregir bug de fechas"));
     }
 
     @Test
-    void getOverdue_retorna200YListaOrdenada() throws Exception {
-        try {
-            Task old = new Task(10L, "Antigua", "desc", TaskStatus.IN_PROGRESS, Priority.MED, 1L, 1L, LocalDate.now().minusDays(5));
-            Task recent = new Task(11L, "Reciente", "desc", TaskStatus.IN_PROGRESS, Priority.MED, 1L, 1L, LocalDate.now().minusDays(2));
-            when(taskService.vencidas()).thenReturn(List.of(old, recent));
-
-            mockMvc.perform(get("/tasks/overdue"))
-                    .andExpect(status().isOk())
-                    .andExpect(jsonPath("$.length()").value(2))
-                    .andExpect(jsonPath("$[0].title").value("Antigua"));
-        } catch (TaskValidationException e) {
-            throw new IllegalStateException("dato de prueba inválido", e);
-        }
+    void getUnassigned_retorna200ConLasTareasDelServicio() throws Exception {
+        when(taskService.sinResponsable()).thenReturn(List.of(
+                tareaConFecha(4L, "Escribir tests MockMvc", null, LocalDate.now().plusDays(7))));
+
+        mockMvc.perform(get("/tasks/unassigned"))
+                .andExpect(status().isOk())
+                .andExpect(jsonPath("$.length()").value(1))
+                .andExpect(jsonPath("$[0].id").value(4))
+                .andExpect(jsonPath("$[0].assigneeId").value(nullValue()));
     }
 
     @Test
-    void getUnassigned_retorna200YIdsYAssigneeNull() throws Exception {
-        try {
-            Task t1 = new Task(4L, "Escribir tests MockMvc", "desc", TaskStatus.TODO, Priority.MED, 1L, null, LocalDate.now().plusDays(7));
-            Task t2 = new Task(6L, "Publicar en la tienda", "desc", TaskStatus.TODO, Priority.MED, 1L, null, LocalDate.now().plusDays(10));
-            when(taskService.sinResponsable()).thenReturn(List.of(t1, t2));
-
-            mockMvc.perform(get("/tasks/unassigned"))
-                    .andExpect(status().isOk())
-                    .andExpect(jsonPath("$.length()").value(2))
-                    .andExpect(jsonPath("$[0].id").value(4))
-                    .andExpect(jsonPath("$[0].assigneeId").value(nullValue()));
-        } catch (TaskValidationException e) {
-            throw new IllegalStateException("dato de prueba inválido", e);
-        }
+    void getTaskPorId_existente_retorna200ConElTitulo() throws Exception {
+        when(taskService.buscarPorId(1L)).thenReturn(Optional.of(tarea(1L, "Diseñar esquema de BD", TaskStatus.TODO)));
+
+        mockMvc.perform(get("/tasks/1"))
+                .andExpect(status().isOk())
+                .andExpect(jsonPath("$.title").value("Diseñar esquema de BD"))
+                .andExpect(jsonPath("$.projectId").value(1));
     }
 
     @Test
@@ -218,6 +213,14 @@ class TaskControllerTest {
         return tareaCon(id, title, status, 1L);
     }
 
+    private Task tareaConFecha(Long id, String title, Long assigneeId, LocalDate dueDate) {
+        try {
+            return new Task(id, title, "desc", TaskStatus.TODO, Priority.MED, 1L, assigneeId, dueDate);
+        } catch (TaskValidationException e) {
+            throw new IllegalStateException("dato de prueba inválido", e);
+        }
+    }
+
     private Task tareaCon(Long id, String title, TaskStatus status, Long projectId) {
         try {
             return new Task(id, title, "desc", status, Priority.MED, projectId, 1L, null);
diff --git a/src/test/java/com/taskflow/unit/ProjectSummaryServiceTest.java b/src/test/java/com/taskflow/unit/ProjectSummaryServiceTest.java
new file mode 100644
index 0000000..bd7c04e
--- /dev/null
+++ b/src/test/java/com/taskflow/unit/ProjectSummaryServiceTest.java
@@ -0,0 +1,67 @@
+package com.taskflow.unit;
+
+import com.taskflow.dto.ProjectSummaryResponse;
+import com.taskflow.model.Priority;
+import com.taskflow.model.Project;
+import com.taskflow.model.Task;
+import com.taskflow.model.TaskStatus;
+import com.taskflow.repository.ProjectRepository;
+import com.taskflow.repository.TaskRepository;
+import com.taskflow.repository.UserRepository;
+import com.taskflow.service.ProjectService;
+import org.junit.jupiter.api.Test;
+import org.junit.jupiter.api.extension.ExtendWith;
+import org.mockito.InjectMocks;
+import org.mockito.Mock;
+import org.mockito.junit.jupiter.MockitoExtension;
+
+import java.time.LocalDate;
+import java.util.List;
+
+import static org.junit.jupiter.api.Assertions.assertEquals;
+import static org.mockito.Mockito.when;
+
+@ExtendWith(MockitoExtension.class)
+class ProjectSummaryServiceTest {
+
+    @Mock
+    private ProjectRepository projectRepository;
+
+    @Mock
+    private TaskRepository taskRepository;
+
+    @Mock
+    private UserRepository userRepository;
+
+    @InjectMocks
+    private ProjectService service;
+
+    private final Project proyecto = new Project(2L, "App Móvil", "d", 1L, null);
+
+    @Test
+    void resumen_proyectoConTareas_yUnaVencida() throws Exception {
+        // tareas: TODO x1, IN_PROGRESS x2, DONE x1; una de las IN_PROGRESS está vencida
+        Task t1 = new Task(5L, "T01", "d", TaskStatus.TODO, Priority.MED, 2L, null, null);
```

</details>


---

<sub>46s</sub>

### `view`

**view the file at C:\Users\Saul\taskflow-copilot-\evidencia\dia4\summary.diff.**

C:\Users\Saul\taskflow-copilot-\evidencia\dia4\summary.diff (lines 400-800)

<details>
<summary>165 lines</summary>

```diff
+        Task t1 = new Task(5L, "T01", "d", TaskStatus.TODO, Priority.MED, 2L, null, null);
+        Task t2 = new Task(6L, "T02", "d", TaskStatus.IN_PROGRESS, Priority.MED, 2L, 1L, LocalDate.now().minusDays(2));
+        Task t3 = new Task(7L, "T03", "d", TaskStatus.IN_PROGRESS, Priority.MED, 2L, 2L, LocalDate.now().plusDays(2));
+        Task t4 = new Task(8L, "T04", "d", TaskStatus.DONE, Priority.MED, 2L, 1L, LocalDate.now().minusDays(5));
+
+        when(taskRepository.findByProjectId(2L)).thenReturn(List.of(t1, t2, t3, t4));
+
+        ProjectSummaryResponse expected = new ProjectSummaryResponse(2L, "App Móvil", 4,
+                java.util.Map.of("TODO", 1L, "IN_PROGRESS", 2L, "DONE", 1L), 1L);
+
+        assertEquals(expected, service.resumen(proyecto));
+    }
+
+    @Test
+    void resumen_proyectoSinTareas_devuelveCeros() {
+        when(taskRepository.findByProjectId(3L)).thenReturn(List.of());
+        Project p3 = new Project(3L, "Vacío", "d", 1L, null);
+
+        ProjectSummaryResponse expected = new ProjectSummaryResponse(3L, "Vacío", 0,
+                java.util.Map.of("TODO", 0L, "IN_PROGRESS", 0L, "DONE", 0L), 0L);
+
+        assertEquals(expected, service.resumen(p3));
+    }
+}
diff --git a/src/test/java/com/taskflow/unit/TaskServiceTest.java b/src/test/java/com/taskflow/unit/TaskServiceTest.java
index 5308aa4..aa528db 100644
--- a/src/test/java/com/taskflow/unit/TaskServiceTest.java
+++ b/src/test/java/com/taskflow/unit/TaskServiceTest.java
@@ -159,93 +159,70 @@ class TaskServiceTest {
         }
     }
 
+    // ==================== S6 Día 2: listados de vencidas y sin responsable ====================
+
+    private static final LocalDate HOY = LocalDate.now();
+
     @Nested
     @DisplayName("vencidas")
     class Vencidas {
 
         @Test
-        void vencidas_devuelveSoloVencidasYOrdenadas() {
-            try {
-                // El repositorio devuelve las tareas en un orden arbitrario: una vencida hace 1 día,
-                // una con fecha en 3 días (futura), una DONE vencida hace 10 días, una sin dueDate,
-                // y una vencida hace 5 días.
-                Task vencidaHace1Dia = new Task(10L, "Vencida1", "desc", TaskStatus.IN_PROGRESS,
-                        Priority.MED, PROYECTO, 1L, LocalDate.now().minusDays(1));
-                Task futuraEn3Dias = new Task(11L, "Futura3", "desc", TaskStatus.IN_PROGRESS,
-                        Priority.MED, PROYECTO, 1L, LocalDate.now().plusDays(3));
-                Task doneVencidaHace10 = new Task(12L, "DoneOld10", "desc", TaskStatus.DONE,
-                        Priority.MED, PROYECTO, 1L, LocalDate.now().minusDays(10));
-                Task sinFecha = new Task(13L, "SinFecha", "desc", TaskStatus.IN_PROGRESS,
-                        Priority.MED, PROYECTO, 1L, null);
-                Task vencidaHace5Dias = new Task(14L, "Vencida5", "desc", TaskStatus.IN_PROGRESS,
-                        Priority.MED, PROYECTO, 1L, LocalDate.now().minusDays(5));
-
-                when(repository.findAll()).thenReturn(List.of(
-                        vencidaHace1Dia,
-                        futuraEn3Dias,
-                        doneVencidaHace10,
-                        sinFecha,
-                        vencidaHace5Dias
-                ));
-
-                List<Task> res = service.vencidas();
-
-                // Solo las dos vencidas (hace 1 día y hace 5 días), ordenadas por fecha asc (la más antigua primero).
-                assertEquals(2, res.size());
-                assertEquals(vencidaHace5Dias.getId(), res.get(0).getId());
-                assertEquals(vencidaHace1Dia.getId(), res.get(1).getId());
-            } catch (TaskValidationException e) {
-                throw new IllegalStateException("dato de prueba inválido", e);
-            }
+        void vencidas_devuelveSoloLasVencidasNoDone_laMasVencidaPrimero() {
+            Task hace1 = tareaCon(1L, TaskStatus.IN_PROGRESS, 5L, HOY.minusDays(1));
+            Task en3 = tareaCon(2L, TaskStatus.TODO, 5L, HOY.plusDays(3));
+            Task doneHace10 = tareaCon(3L, TaskStatus.DONE, 5L, HOY.minusDays(10));
+            Task sinFecha = tareaCon(4L, TaskStatus.TODO, 5L, null);
+            Task hace5 = tareaCon(5L, TaskStatus.TODO, 5L, HOY.minusDays(5));
+            when(repository.findAll()).thenReturn(List.of(hace1, en3, doneHace10, sinFecha, hace5));
+
+            List<Long> ids = service.vencidas().stream().map(Task::getId).toList();
+
+            // El repositorio las entrega como 1, 5: sin el .sorted(TaskOrders.POR_FECHA) este assert falla.
+            assertEquals(List.of(5L, 1L), ids);
+        }
+
+        @Test
+        void vencidas_sinNingunaVencida_devuelveListaVacia() {
+            when(repository.findAll()).thenReturn(List.of(tareaCon(1L, TaskStatus.TODO, 5L, HOY.plusDays(1))));
+
+            assertEquals(List.of(), service.vencidas());
         }
     }
 
     @Nested
-    @DisplayName("SinResponsable")
+    @DisplayName("sinResponsable")
     class SinResponsable {
 
         @Test
-        void sinResponsable_devuelveSoloSinAsignarYOrdenadas() {
-            try {
-                Task sinResp10 = new Task(20L, "Sin10", "desc", TaskStatus.IN_PROGRESS,
-                        Priority.MED, PROYECTO, null, LocalDate.now().plusDays(10));
-                Task conResp = new Task(21L, "ConResp", "desc", TaskStatus.TODO,
-                        Priority.MED, PROYECTO, 2L, LocalDate.now().plusDays(5));
-                Task sinFecha = new Task(22L, "SinFecha", "desc", TaskStatus.TODO,
-                        Priority.MED, PROYECTO, null, null);
-                Task sinResp2 = new Task(23L, "Sin2", "desc", TaskStatus.TODO,
-                        Priority.MED, PROYECTO, null, LocalDate.now().plusDays(2));
-
-                when(repository.findAll()).thenReturn(List.of(
-                        sinResp10,
-                        conResp,
-                        sinFecha,
-                        sinResp2
-                ));
-
-                List<Task> res = service.sinResponsable();
-
-                assertEquals(3, res.size());
-                List<Long> ids = res.stream().map(Task::getId).toList();
-                assertEquals(List.of(23L, 20L, 22L), ids);
-            } catch (TaskValidationException e) {
-                throw new IllegalStateException("dato de prueba inválido", e);
-            }
+        void sinResponsable_devuelveLasSinResponsableEnCualquierEstado_porFechaYSinFechaAlFinal() {
+            // Estados mezclados a propósito (TODO, IN_PROGRESS, DONE): la regla es solo el responsable.
+            Task en10 = tareaCon(1L, TaskStatus.TODO, null, HOY.plusDays(10));
+            Task conResponsable = tareaCon(2L, TaskStatus.TODO, 5L, HOY.plusDays(1));
+            Task sinFecha = tareaCon(3L, TaskStatus.IN_PROGRESS, null, null);
+            Task en2 = tareaCon(4L, TaskStatus.DONE, null, HOY.plusDays(2));
+            when(repository.findAll()).thenReturn(List.of(en10, conResponsable, sinFecha, en2));
+
+            List<Long> ids = service.sinResponsable().stream().map(Task::getId).toList();
+
+            // El repositorio las entrega como 1, 3, 4: sin el .sorted(TaskOrders.POR_FECHA) este assert falla.
+            assertEquals(List.of(4L, 1L, 3L), ids);
         }
 
         @Test
-        void sinResponsable_conSoloAsignadas_devuelveListaVacia() {
-            try {
-                Task c1 = new Task(30L, "C1ok", "desc", TaskStatus.TODO, Priority.MED, PROYECTO, 5L, null);
-                Task c2 = new Task(31L, "C2ok", "desc", TaskStatus.TODO, Priority.MED, PROYECTO, 6L, LocalDate.now().plusDays(1));
-                when(repository.findAll()).thenReturn(List.of(c1, c2));
-
-                List<Task> res = service.sinResponsable();
-
-                assertEquals(0, res.size());
-            } catch (TaskValidationException e) {
-                throw new IllegalStateException("dato de prueba inválido", e);
-            }
+        void sinResponsable_todasConResponsable_devuelveListaVacia() {
+            when(repository.findAll()).thenReturn(List.of(tareaCon(1L, TaskStatus.TODO, 5L, null)));
+
+            assertEquals(List.of(), service.sinResponsable());
+        }
+    }
+
+    /** Fabrica una Task REAL con estado, responsable y fecha a elección (null = sin responsable / sin fecha). */
+    private Task tareaCon(Long id, TaskStatus status, Long assigneeId, LocalDate dueDate) {
+        try {
+            return new Task(id, "Tarea " + id, "desc", status, Priority.MED, PROYECTO, assigneeId, dueDate);
+        } catch (TaskValidationException e) {
+            throw new IllegalStateException("dato de prueba inválido", e);
         }
     }
```

</details>


---

<sub>57s</sub>

### Copilot

Abriendo archivos relevantes para validar contexto: ProjectService, ProjectController, TaskService, ProjectMapper, ProjectController original region, TaskController, TaskRepository to confirm findByProjectId, tests modified. Ejecutando lecturas.

---

<sub>57s</sub>

### `view`

**view the file at C:\Users\Saul\taskflow-copilot-\src\main\java\com\taskflow\service\ProjectService.java.**

C:\Users\Saul\taskflow-copilot-\src\main\java\com\taskflow\service\ProjectService.java

<details>
<summary>112 lines</summary>

```
package com.taskflow.service;

import com.taskflow.dto.ProjectRequest;
import com.taskflow.exception.ProjectNotFoundException;
import com.taskflow.model.Project;
import com.taskflow.model.Task;
import com.taskflow.model.User;
import com.taskflow.repository.ProjectRepository;
import com.taskflow.repository.TaskRepository;
import com.taskflow.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * ProjectService — la capa de negocio del lado Project. Cero HTTP aquí (el "no existe" se traduce con
 * orElseThrow -> ProjectNotFoundException; el advice le pone el 404).
 *
 * Cambios de HOY (S2D4) — y por qué la promesa del día NO lo cubre:
 *   - MP-4: el modelo Project se aplanó (User owner -> Long ownerId), así que 'crear' y 'reemplazar'
 *     manejan un ownerId (Long), no un objeto User. Antes 'crear' construía con 0L (convención del
 *     InMemory de "aún sin id"); ahora construye con null y la BD asigna el id (IDENTITY).
 *   - MP-6: 'tareasDe' cambió su stream-filter de findAll() por taskRepository.findByProjectId(id)
 *     — la nota de D3 ("en D4 esto se vuelve un query method") se paga AQUÍ. La promesa "no tocar el
 *     servicio" protege a TaskService (que no se tocó), no a ProjectService (que ya se tocó en MP-4).
 */
@Service
public class ProjectService {

    /**
     * Resumen de un proyecto: cuenta tareas por estado y vencidas. Recibe el proyecto ya cargado
     * (el controller decide 404 con buscarPorId). Reutiliza Task.estaVencida() para la regla de
     * vencido.
     */
    public com.taskflow.dto.ProjectSummaryResponse resumen(Project proyecto) {
        java.util.List<com.taskflow.model.Task> tareas = taskRepository.findByProjectId(proyecto.getId());
        long total = tareas.size();
        java.util.Map<String, Long> byStatus = new java.util.HashMap<>();
        // Inicializar las tres claves a 0 para garantizar presencia aunque no haya tareas
        for (com.taskflow.model.TaskStatus s : com.taskflow.model.TaskStatus.values()) {
            byStatus.put(s.name(), 0L);
        }
        for (com.taskflow.model.Task t : tareas) {
            byStatus.put(t.getStatus().name(), byStatus.get(t.getStatus().name()) + 1);
        }
        long overdue = tareas.stream().filter(com.taskflow.model.Task::estaVencida).count();
        return com.taskflow.mapper.ProjectMapper.aSummary(proyecto.getId(), proyecto.getName(), total, byStatus, overdue);
    }

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;   // D5: para resolver el owner desde el username del JWT

    public ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository,
                          UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    /** Todos los proyectos. */
    public List<Project> listar() {
        return projectRepository.findAll();
    }

    /** Un proyecto por id (el Optional sube tal cual: el controller decide 404 vs 200). */
    public Optional<Project> buscarPorId(Long id) {
        return projectRepository.findById(id);
    }

    /**
     * Las tareas de un proyecto: MP-6 sustituye el stream-filter de D2 por la derived query
     * taskRepository.findByProjectId(projectId) — el LIKE... perdón, el WHERE project_id = ? lo hace
     * la BD (viajan solo las filas del proyecto). "no existe el proyecto" (404) lo decide el
     * controller con buscarPorId; ESTE método, si el proyecto existe pero no tiene tareas, devuelve
     * [] (-> 200 con []). No son lo mismo.
     */
    public List<Task> tareasDe(Long projectId) {
        return taskRepository.findByProjectId(projectId);
    }

    /**
     * Crea un proyecto (POST): el request trae name y description; el ownerId ya NO es una constante
     * (murió el 1L fijo de D3) — se resuelve del USERNAME AUTENTICADO (el que puso el JWT en el
     * Authentication). El dueño no lo decide el cliente ni una semilla: es QUIEN llama. createdAt = hoy;
     * id == null -> la BD lo asigna (IDENTITY).
     */
    public Project crear(ProjectRequest request, String ownerUsername) {
        User owner = userRepository.findByUsername(ownerUsername)
                .orElseThrow(() -> new UsernameNotFoundException(ownerUsername));
        Project nuevo = new Project(null, request.name(), request.description(),
                owner.getId(), LocalDate.now());
        return projectRepository.save(nuevo);
    }

    /**
     * Reemplazo COMPLETO (PUT): existe -> reconstruye con el MISMO id, conservando ownerId y createdAt
     * (el cliente no los toca); name y description vienen del request. save con id presente = update.
     * No existe -> 404.
     */
    public Project reemplazar(Long id, ProjectRequest request) {
        Project actual = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
        Project reemplazo = new Project(actual.getId(), request.name(), request.description(),
                actual.getOwnerId(), actual.getCreatedAt());
        return projectRepository.save(reemplazo);
    }

    /**
     * Elimina un proyecto (DELETE) con CASCADA MANUAL: borra primero sus tareas (regla "no Task sin
     * Project" — y además la FK task.project_id lo EXIGE: borrar el proyecto con tareas colgando daría
     * una violación de integridad) y luego el proyecto. No existe -> 404. La regla owner/ADMIN llega
     * en D5 (hoy queda abierto, documentado en el @Operation del controller).
     */
    public void eliminar(Long id) {
        projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
        tareasDe(id).forEach(t -> taskRepository.deleteById(t.getId()));   // cascada manual (la FK obliga el orden)
        projectRepository.deleteById(id);
    }
}
```

</details>


---

<sub>1m 10s</sub>

### `view`

**view the file at C:\Users\Saul\taskflow-copilot-\src\main\java\com\taskflow\repository\TaskRepository.java.**

C:\Users\Saul\taskflow-copilot-\src\main\java\com\taskflow\repository\TaskRepository.java

<details>
<summary>36 lines</summary>

```
package com.taskflow.repository;

import com.taskflow.model.Task;
import com.taskflow.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * TaskRepository — EL MOMENTO NARRATIVO DEL DÍA (MP-6). Ayer era una interfaz que redeclaraba
 * save/findById/findAll/deleteById, implementada por InMemoryTaskRepository. HOY extiende
 * JpaRepository&lt;Task, Long&gt; y esos 4 métodos VIENEN GRATIS (+ count/existsById/etc.): NO se
 * implementa nadie, un PROXY de runtime lo hace (la misma "magia" de DI de S2D1).
 *
 * La paga de la interfaz extraída en S1D5: TaskService/ReportService dependían de ESTE contrato desde
 * entonces, y sus firmas (Optional&lt;Task&gt; findById, void deleteById) se alinearon a Spring Data
 * desde S2D1 — por eso hoy el swap memoria->BD NO toca el servicio. "git diff de TaskService = vacío".
 * InMemoryTaskRepository dejó de compilar y SE ELIMINÓ (git lo recuerda; borrar código es sano
 * cuando la interfaz sobrevive).
 *
 * DERIVED QUERIES: el NOMBRE del método es la query. Gramática findBy + propiedad + And/Not/
 * Containing/IgnoreCase/OrderBy, y countBy. Se validan AL ARRANCAR: un nombre con una propiedad que
 * no existe (p.ej. findByEstado) lanza QueryCreationException y la app NO levanta — error de arranque,
 * no de runtime. Estas seis se prueban en TaskRepositoryTest (@DataJpaTest).
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

    /** Tareas en un estado dado. La consume ProjectService/ReportService y las vistas por estado. */
    List<Task> findByStatus(TaskStatus status);

    /** Tareas de un proyecto (por la columna project_id). La consume ProjectService.tareasDe (MP-6). */
    List<Task> findByProjectId(Long projectId);

    /** Combina dos criterios con And: tareas de un asignado en un estado. La consume el stretch de D5. */
    List<Task> findByAssigneeIdAndStatus(Long assigneeId, TaskStatus status);

    /** LIKE case-insensitive: título que CONTIENE el fragmento (la BD hace el filtrado). */
    List<Task> findByTitleContainingIgnoreCase(String fragment);

    /** El complemento de findByStatus: todas MENOS las de ese estado (Not). Sirve a "pendientes". */
    List<Task> findByStatusNot(TaskStatus status);

    /** Cuenta en la BD (no trae filas para contarlas): conteo por estado. */
    long countByStatus(TaskStatus status);
}
```

</details>


---

<sub>1m 35s</sub>

### Copilot

Resumen de la revisión comparando evidencia/dia4/summary.diff con specs/summary.md.

| # | Gravedad | Archivo:línea | Punto checklist | Qué pasa | Qué harías |
|---|---:|---|---|---|---|
| 1 | Bloquea | src/test/java/.../TaskControllerTest.java (modificado) | 2 — Tests existentes | Se modificó un test existente en lugar de añadir tests nuevos. Cambiar tests previos es el hallazgo más grave. | Revertir modificaciones a ese test; mover casos nuevos a archivos nuevos (p.ej. TaskListingsControllerTest). |
| 2 | Corregir | src/main/java/com/taskflow/controller/TaskController.java + src/main/java/com/taskflow/service/TaskService.java | 1 — Alcance | El diff altera controladores/servicios de tareas (renombrados/movidos) fuera del alcance pedido (solo summary). | Limitar el PR al endpoint summary; extraer estos cambios a PR aparte con su justificación y pruebas. |
| 3 | Corregir | src/test/java/com/taskflow/slice/ProjectSummaryControllerTest.java | 4/5 — Contrato / Convenciones | @AutoConfigureMockMvc(addFilters = false) desactiva filtros de seguridad en el slice test; no se verifica comportamiento de auth (spec exige 401 sin token). | Añadir un test que verifique 401 cuando no hay token; o documentar por qué el slice usa filtros desactivados y añadir un test de seguridad separado. |
| 4 | Sugerencia | src/main/java/com/taskflow/service/ProjectService.java | 3 — Reglas del dominio | Se reutiliza Task.estaVencida() correctamente y se inicializan las tres claves. Ninguna regla reescrita. | (Opcional) usar EnumMap\<TaskStatus,Long> internamente y convertir a Map\<String,Long> al mapper para claridad/eficiencia. |
| 5 | Sugerencia | src/test/java/com/taskflow/unit/ProjectSummaryServiceTest.java | 7 — Tests que prueban algo | Tests unitarios cubren proyecto con tareas y vacío; usan Task ctor que puede lanzar TaskValidationException sin try/catch (método lanza Exception). | Mantener (es válido) o envolver creación en helpers con mensajes claros; no es blocking. |

Casos sin test
- Verificación de 401/seguridad sobre GET /projects/{id}/summary (la regla 4 de la spec).  
- Test de integración (perfil h2) que valide los valores contra la semilla (criterios de aceptación): falta (esto es parte del paso de verificación en la spec).  

Veredicto: CAMBIOS PEDIDOS

Conclusión corta: la implementación funcional del endpoint summary cumple el contrato y reutiliza Task.estaVencida(), y hay tests unit/slice que cubren 200/404/valores. Sin embargo hay cambios de archivos fuera de alcance y se modificó un test existente — revertir/extraer esos cambios y añadir el test de seguridad/validación en h2 antes de merge.

---

<sub>Generated by [GitHub Copilot CLI](https://github.com/features/copilot/cli)</sub>
