# Comentarios ciertos de Copilot code review

## 1. ReasignarTareaControllerTest.java

El caso 422 comprueba el código de estado, pero no comprueba el mensaje exacto exigido por `specs/assignee.md`.

Debe comprobar:

`$.message = "No se puede reasignar una tarea terminada."`

## 2. ReasignarTareaControllerTest.java

El test `patchAssignee_tareaDone_devuelve422` crea la tarea con `TaskStatus.TODO`, aunque el caso representa una tarea terminada.

Debe usar `TaskStatus.DONE` y conservar un responsable.