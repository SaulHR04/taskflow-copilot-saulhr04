# Proyecto final · Semana 6 · GitHub Copilot


**Alumno:** `Saul Eduardo Hernández Rodríguez` · **Usuario de GitHub:** `saulhr04`

## 1. Qué construí



| | Feature | Especificación |
|---|---|---|
| [ x] | `PATCH /tasks/{id}/assignee` — cambiar el responsable | [`specs/assignee.md`](../specs/assignee.md) |


## 2. El pull request

- **URL del PR (mergeado):** `https://github.com/saulhr04/taskflow-copilot-saulhr04/pull/5`
- **Commit del merge en `main`:** `77b2f04 (HEAD -> main, origin/main, origin/HEAD) Merge pull request #5 from SaulHR04/feature/assignee`
- **Comentarios de Copilot code review:** `3`

## 3. Cómo lo hice



| Paso | Qué hice | Evidencia |
|---|---|---|
| Rama y spec | `git switch -c feature/assignee` y copié la spec a `specs/` | `git log --oneline main..feature/assignee` (antes del merge) |
| Implementación | `copilot -p "/crear-endpoint-taskflow …"` con `gpt-5-mini` | `semana6/sesion-implementacion.md` (tiene la línea `Skill "crear-endpoint-taskflow" loaded successfully`) |
| Revisión | agente `revisor` sobre `semana6/proyecto-final.diff` | `semana6/revision.md` (termina con `Veredicto:`) |
| Tests | `mvn test` en verde | `84` |
| Comprobación REST | `verificar.ps1` con `casos-assignee.ps1` | sección 5 de este documento |
| Code review | Copilot en el PR | la pestaña *Files changed* del PR |

## 4. Qué hizo el agente y qué corregí yo


| # | Qué hizo mal el agente (archivo) | Quién lo detectó | Cómo quedó corregido |
|---|---|---|---|
| 1 | `El test `patchAssignee_tareaDone_devuelve422` usaba `TaskStatus.TODO` aunque representaba una tarea terminada (`ReasignarTareaControllerTest.java`). | Copilot code review | Se cambió a `TaskStatus.DONE` conservando responsable. Corregido con Copilot y commit `4c22556` |
| 2 | `El test del error 422 verificaba el código de estado, pero no el mensaje exacto requerido por la spec (`ReasignarTareaControllerTest.java`). | Copilot code review | Se agregó la comprobación de `$.message = "No se puede reasignar una tarea terminada."`. Corregido con Copilot y commit `4c22556`.` |

**Lo que el agente hizo bien a la primera** (una o dos líneas): `La implementación principal del endpoint `PATCH /tasks/{id}/assignee` y sus reglas REST funcionaron correctamente`

## 5. Comprobaciones REST



```text
[OK]    GET /tasks/overdue devuelve solo la tarea 7
[OK]    GET /tasks/unassigned devuelve las tareas 4 y 6
[OK]    GET /projects/1/summary
[OK]    GET /projects/2/summary
[OK]    GET /projects/3/summary
[OK]    GET /projects/99/summary responde 404
[OK]    GET /projects/1/summary sin token responde 401
[OK]    PATCH /tasks/4/assignee asigna a luis
[OK]    GET /tasks/4 conserva el responsable nuevo
[OK]    PATCH /tasks/4/status a DONE ahora responde 200
[OK]    PATCH /tasks/2/assignee (DONE) responde 422
[OK]    PATCH /tasks/99/assignee responde 404
[OK]    PATCH /tasks/6/assignee con {} responde 400 y nombra assigneeId
[OK]    PATCH /tasks/6/assignee con 0 responde 400
[OK]    PATCH /tasks/6/assignee sin token responde 401
App detenida (PID 13924).
[OK]    App apagada: el puerto 8080 ya no responde
RESULTADO: 16/16 OK
```

## 6. Créditos de la semana



| Qué | AI credits |
|---|---|
| Usados en septiembre según github.com (incluye semanas anteriores si usaste Copilot antes) | `246.23` |
| Implementación con la skill (`AI Credits` del PF-2) | `5.18` |
| Revisión del `revisor` (`AI Credits` del PF-3) | `2.06` |
| Correcciones del PF-4 y del PF-6, si hubo (`AI Credits`) | `3.07` |
