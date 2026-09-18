  # Evidencia de la semana · GitHub Copilot

  **Alumno:** Saul Eduardo Hernández Rodríguez · **Repo:** https://github.com/SaulHR04/taskflow-copilot-saulhr04

  ## Día 1 · La CLI

  - **Qué construí:** Configuré las instrucciones de GitHub Copilot para el repositorio y documenté la arquitectura de TaskFlow.
  - **Dónde está:** `.github/copilot-instructions.md`, `docs/ARQUITECTURA.md`.
  - **Cómo se comprueba:** `evidencia/dia1/verificador.txt`, última línea: `0 NO EXISTE`.
  - **Qué no salió:** nada.

  ## Día 2 · Especificar, implementar y revisar

  - **Qué construí:** Implementé los endpoints para consultar tareas vencidas y tareas sin responsable.
  - **Dónde está:** `specs/overdue.md`, `src/main/java/com/taskflow/controller/TaskController.java`, `src/main/java/com/taskflow/service/TaskService.java`.
  - **Cómo se comprueba:** `evidencia/dia2/suite-main.txt` registra `72` pruebas, sin fallos ni errores; el PR está en `evidencia/dia2/pr.txt`.
  - **Qué no salió:** nada aunque se provocó intencionalmente un fallo en la ordenación de tareas vencidas y se restauró el código después de comprobar que las
  pruebas lo detectaban.

  ## Día 3 · MCP

  - **Qué construí:** Configure e hice uso de los servidores MCP de TaskFlow, GitHub, AWS Knowledge y Playwright; el agente consultó tareas vencidas y creo un
  issue en GitHub.
  - **Dónde está:** `taskflow-mcp/`, `evidencia/dia3/mcp-list.txt`, `evidencia/dia3/integrador.md`, `evidencia/dia3/playwright-tarea.txt`.
  - **Cómo se comprueba:** `evidencia/dia3/conteos.txt` confirma una tarea vencida y un issue creado; `playwright-tarea.txt` muestra la tarea creada
  mediante Playwright.
  - **Qué no salió:** nada. 

  ## Día 4 · Skills y agentes

  - **Qué construí:** Creé skills para implementar endpoints, verificar TaskFlow y limpiar AWS, además configure los agentes `revisor`, `tester` y `auditor-
  aws`.
  - **Dónde está:** `.github/skills/`, `.github/agents/`, `evidencia/dia4/`.
  - **Cómo se comprueba:** `evidencia/dia4/verificar.txt` termina con `RESULTADO: 8/8 OK`.
  - **Qué no salió:** inicialmente el revisor busco la carpeta `evidence` y recibió el error `Path does not exist`; posteriormente localizó la ruta correcta
  `evidencia` y completó la revisión.

  ## Día 5 · VS Code y proyecto final

  - **Qué construí:** Implementé el endpoint `PATCH /tasks/{id}/assignee` para reasignar responsables, con validaciones, pruebas, revisión de Copilot y pull
  request integrado.
  - **Dónde está:** `specs/assignee.md`, `semana6/README.md`, `src/main/java/com/taskflow/controller/TaskController.java`, `src/main/java/com/taskflow/
  service/TaskService.java`.
  - **Cómo se comprueba:** `semana6/README.md` registra `RESULTADO: 16/16 OK` y el PR integrado es
  https://github.com/saulhr04/taskflow-copilot-saulhr04/pull/5.
  - **Qué no salió:** el primer código generado tenía dos detalles incorrectos en una prueba del caso `422`; fueron detectados por Copilot code review y
  corregidos.

 -----------
### Configuración UTF-8

 configuración UTF-8 durante el desarrollo del proyecto.

![Configuración UTF-8](Capturas/1.1_ConfiguracionUTF-8.PNG)

### Revisión archivos

 revisión archivos durante el desarrollo del proyecto.

![Revisión Archivos](Capturas/1.2_RevisionArchivos.PNG)

### Revisión login

 revisión login durante el desarrollo del proyecto.

![Revisión Login](Capturas/1.3_RevisionLogin.PNG)

### Herencia sub agentes de GPT

 herencia Sub Agentes de lo GPT  

![Herencia Sub Agentesde Gpt](Capturas/1.4_HerenciaSubAgentesdeGpt.PNG)

### Comprobación de test

 la validación realizada para confirmar test.

![Comprobación De Test](Capturas/1.5_ComprobacionDeTest.PNG)

### Branch nueva

 branch Nueva feature/overdue.

![Branch Nueva](Capturas/1.6_BranchNueva.PNG)

### Creación y comprobación carpeta Specs

 la validación realizada para confirmar carpeta specs.

![Creación y Comprobación Carpeta Specs](Capturas/1.6_CreacionYComprobacionCarpetaSpecs.PNG)

### Comprobación Usage

 la validación realizada para confirmar usage.

![Comprobación Usage](Capturas/1.7_ComprobacionUsage.PNG)

### Creación y comprobación carpeta Specs

 la validación realizada para confirmar carpeta specs.

![Creación y Comprobación Carpeta Specs](Capturas/1.8_CreacionYComprobacionCarpetaSpecs.PNG)

### Prompt 1

 la instrucción enviada para solicitar 1.

![Prompt1](Capturas/1.9_Prompt1.PNG)

### Resultado prompt 1

 la respuesta generada por el agente tras procesar la instrucción.

![Resultado Prompt1](Capturas/1.10_ResultadoPrompt1.PNG)

### Test PS2

 la ejecución de las pruebas y el resultado obtenido.

![Test PS2](Capturas/1.11_TestPS2.PNG)

### Comprobar test existentes

 la validación realizada para confirmar test existentes.

![Comprobar Test Existentes](Capturas/1.12_ComprobarTestExistentes.PNG)

### Failure en test

 la ejecución de las pruebas y el resultado obtenido.

![Failure En Test](Capturas/1.13_FailureEnTest.PNG)

### Task


![Task](Capturas/1.14_Task.PNG)

### Comprobación test

 la validación realizada para confirmar test.

![Comprobación Test](Capturas/1.15_ComprobacionTest.PNG)

### Revisión con prompt

 revisión Con prompt de lo que se cambio en la rama. 

![Revisión Con Prompt](Capturas/1.16_RevisionConPrompt.PNG)

### Comprobación

 la validación realizada para confirmar el resultado de la actividad.

![Comprobación](Capturas/1.17_Comprobacion.PNG)

### Rama commit comprobación

 Commit para la spec get/task/unassigned

![Rama Commit Comprobación](Capturas/1.18_Brench_Commit_Comprobacion.PNG)

### Prompt Plan

 prompt enviado para solicitar plan.

![Prompt Plan](Capturas/1.19_Prompt_Plan.PNG)

### Rama experimento

la gestión de la rama utilizada durante el desarrollo.

![Rama Experimento](Capturas/1.20_Brench_Experimento.PNG)

### Test Failure Rama 3

ejecución de las pruebas y el resultado obtenido de los test .

![Test Failure Rama3](Capturas/1.21_Test_Failure_Brench3.PNG)

### Prompt Test Fallan

la instrucción enviada para solicitar a copilot los test fallan.

![Prompt Test Fallan](Capturas/1.22_Prompt_TestFallan.PNG)

### Comprobación de Eliminación de bug

 la validación realizada para confirmar eliminación de bug.

![Comprobación de Eliminación de bug](Capturas/1.23_Comprobacion_de_eliminacion_de_bug.PNG)

### Comprobación bug corregido

 la validación realizada para confirmar bug corregido.

![Comprobación bug corregido](Capturas/1.24_Comprobacion_bug_corregido.PNG)

### Eliminación Branch

 eliminación Branch durante el desarrollo del proyecto.

![Eliminación Branch](Capturas/1.25_Eliminacion_Branch.PNG)

### Branch Eliminada

 branch Eliminada durante el desarrollo del proyecto.

![Branch Eliminada](Capturas/1.26_Branch_Eliminada.PNG)

### Pull Request

 la preparación o revisión de los cambios para su integración.

![Pull Request](Capturas/1.27_PullRequest.PNG)

### Merge Realizado

 la integración de los cambios en la rama correspondiente.

![Merge Realizado](Capturas/1.28_MergeRealizado.PNG)

### Copilot Revisión

 copilot Revisión durante el desarrollo del proyecto.

![Copilot Revisión](Capturas/1.29_CopilotRevision.PNG)

### Comprobación Final

 la validación realizada para confirmar final.

![Comprobación Final](Capturas/1.30_ComprobacionFinal.PNG)

### Comprobación Final

 la validación realizada para confirmar final2.

![Comprobación Final2](Capturas/1.31_ComprobacionFinal2.PNG)

### Resultado Final
 

![Resultado Final](Capturas/1.32_ResultadoFinal.PNG)

### Generar Enlace PR

 generar enlace PR durante el desarrollo del proyecto.

![Generar Enlace PR](Capturas/1.33_GenerarEnlacePR.PNG)

### Usage Final

 usage final durante el desarrollo del proyecto.

![Usage Final](Capturas/1.34_UsageFinal.PNG)

### Spring No Responde

 spring No Responde durante el desarrollo del proyecto.

![Spring No Responde](Capturas/1.35_SpringNoResponde.PNG)

### Borrar Rama

 la gestión de la rama utilizada durante el desarrollo.

![Borrar Rama's](Capturas/1.36_BorrarBrench%27s.PNG)

## Día 3



 inicio día 3 

![Inicio día3](Capturas/2.1_InicioDia3.PNG)

### Pull y carpeta Copilot día 3

![Pully Carpeta Copilotdía3](Capturas/2.2_PullyCarpetaCopilotdia3.PNG)

### Endpoints

 endpoints durante el desarrollo del proyecto.

![Endpoints](Capturas/2.3_Endpoints.PNG)

### Comprobación repositorio

 la validación realizada para confirmar repo.

![Comprobación Repo](Capturas/2.4_ComprobacionRepo.PNG)

### Version NPX

 version NPX durante el desarrollo del proyecto.

![Version NPX](Capturas/2.5_VersionNPX.PNG)

### Copiar y compilar Servidor MCP



![Copiar y Compilar Servidor MCP](Capturas/2.6_CopiarYCompilarServidorMCP.PNG)

### Play Wright MCP

 Instalacion de play Wright MCP.

![Play Wright MCP](Capturas/2.7_PlayWrightMCP.PNG)

### Arrancar Task Flow

 el inicio del servicio y la confirmación de que se encuentra disponible.

![Arrancar Task Flow](Capturas/2.8_ArrancarTaskFlow.PNG)

### Task Flow Iniciado

 el inicio del servicio y la confirmación de que se encuentra disponible.

![Task Flow Iniciado](Capturas/2.9_TaskFlowIniciado.PNG)

### No MCP Configurado En Copilot

![No MCP Configurado En Copilot](Capturas/2.10_NoMCPConfiguradoEnCopilot.PNG)

### Copilot Comando MCP

![Copilot Comando MCP](Capturas/2.11_CopilotComandoMCP.PNG)

### Preparar incidencia

 el registro y seguimiento de una incidencia relacionada con el trabajo realizado.

![Preparar incidencia](Capturas/2.12_PrepararIssue.PNG)

### Iniciar Copilot Con ALL GitHub MCP


![Iniciar Copilot Con ALL GitHub MCP](Capturas/2.13_IniciarCopilotConALLGithubMCP.PNG)

### Crear incidencia Con Copilot

 el registro y seguimiento de una incidencia relacionada con el trabajo realizado.

![Crear incidencia Con Copilot](Capturas/2.14_CrearISSUEConCopilot.PNG)

### Incidencia Creado

 el registro y seguimiento de una incidencia relacionada con el trabajo realizado.

![Incidencia Creado](Capturas/2.15_IssueCreado.PNG)

### Incidencia En GitHub

 el registro y seguimiento de una incidencia relacionada con el trabajo realizado.

![Incidencia En GitHub](Capturas/2.16_IssueEnGithub.PNG)

### Comparar Object

 comparar Object durante el desarrollo del proyecto.

![Comparar Object](Capturas/2.17_CompararObject.PNG)

### Registrar AWS Knowledge

 registrar AWS Knowledge durante el desarrollo del proyecto.

![Registrar AWS Knowledge](Capturas/2.18_RegistrarAWSKnowledge.PNG)

### Prompt Disponibilidad

 la instrucción enviada para solicitar disponibilidad.

![Prompt Disponibilidad](Capturas/2.19_PromptDisponibilidad.PNG)

### Compartir Sesion AWS

 compartir Sesion AWS durante el desarrollo del proyecto.

![Compartir Sesion AWS](Capturas/2.20_CompartirSesionAWS.PNG)

### Test Compartido AWS

 la ejecución de las pruebas y el resultado obtenido.

![Test Compartido AWS](Capturas/2.21_TestCompartidoAWS.PNG)

### Comprobación Productos Servidor MCP

 la validación realizada para confirmar productos servidor mcp.

![Comprobación Productos Servidor MCP](Capturas/2.22_ComprobacionProductosServidorMCP.PNG)

### Registrar Play Wright

 registrar Play Wright durante el desarrollo del proyecto.

![Registrar Play Wright](Capturas/2.23_RegistrarPlayWright.PNG)

### Copilot List

 copilot List durante el desarrollo del proyecto.

![Copilot List](Capturas/2.24_CopilotList.PNG)

### Prompt crear tarea

 prompt enviado para solicitar crear tarea.

![Prompt Crear Tarea](Capturas/2.25_PromptCrearTarea.PNG)

### Agente funcionando

![Agente Funcionando](Capturas/2.26_AgenteFuncionando.PNG)

### Flujo Del Agente y Compartido De Sesion

![Flujo Del Agente y Compartido De Sesion](Capturas/2.27_FlujoDelAgenteYCompartidoDeSesion.PNG)

### Revisión Script PS

![Revisión Script PS](Capturas/2.28_RevisionScriptPS.PNG)

### Comprobar Si No Uso Herramientas Prohibidas

 la validación realizada para confirmar no uso herramientas prohibidas.

![Comprobar Si No Uso Herramientas Prohibidas](Capturas/2.29_ComprobarSiNoUsoHerramientasProhibidas.PNG)

### Comprobar Task Flow Test

 la validación realizada para confirmar task flow test.

![Comprobarsi Task Flow Test](Capturas/2.30_ComprobarsiTaskFlowTest.PNG)

### Comprobar Herramientas

 la validación realizada para confirmar herramientas.

![Comprobar Herramientas](Capturas/2.31_ComprobarHerramientas.PNG)

### MCP Lista
![MCP Lista](Capturas/2.32_MCPLista.PNG)

### Com MCP Copilot
![Com MCP Copilot](Capturas/2.33_ComMCPCopilot.PNG)

### Prompt Tareas Vencidas

prompt enviado para solicitar tareas vencidas.

![Prompt Tareas Vencidas](Capturas/2.34_PromptTareasVencidas.PNG)

### Prompt Crear Tarea

 la instrucción enviada para solicitar crear tarea.

![Prompt Crear Tarea](Capturas/2.35_PromptCrearTarea.PNG)

### Creación Token y Comprobación

 la validación realizada para confirmar el resultado de la actividad.

![Creación Token y Comprobación](Capturas/2.36_CreacionTokenYComprobacion.PNG)

### Comprobación Tarea Creada

 la validación realizada para confirmar tarea creada.

![Comprobación Tarea Creada](Capturas/2.37_ComprobacionTareaCreada.PNG)

### Task Flow Apagado y Prompt Listar Tareas

![Task Flow Apagado y Prompt Listar Tareas](Capturas/2.38_TaskFlowApagadoYPromptListarTareas.PNG)

### Copilot No Arranco
![Copilot No Arranco](Capturas/2.39_CopilotNoArranco.PNG)

### Actualizacion Con Due Date Intacto
![Actualizacion Con Due Date Intacto](Capturas/2.40_ActualizacionConDueDateIntacto.PNG)

### Creación incidencia Tareas Vencidas

 el registro y seguimiento de una incidencia relacionada con el trabajo realizado.

![Creación incidencia Tareas Vencidas](Capturas/2.41_CreacionIssueTareasVencidas.PNG)

### Comprobación Share File

 la validación realizada para confirmar share file.

![Comprobación Share File](Capturas/2.42_ComprobacionShareFile.PNG)

### Comprobación PS

 la validación realizada para confirmar ps.

![Comprobación PS](Capturas/2.43_ComprobacionPS.PNG)

### Commit día3

 el registro de los cambios realizados en el repositorio.

![Commit día3](Capturas/2.44_CommitDia3.PNG)

### Limpieza

 la limpieza efectuada al concluir la actividad.

![Limpieza](Capturas/2.45_Limpieza.PNG)

## Día 4

### Skills Copilot

![Skills Copilot](Capturas/3.1_SkillsCopilot.PNG)

### Romper Skill

![Romper Skill](Capturas/3.2_RomperSkill.PNG)

### Arreglar Skill

![Arreglar Skill](Capturas/3.3_ArreglarSkill.PNG)

### Invocación Vía Skill

![Invocación Vía Skill](Capturas/3.4_InvocacionV%C3%ADaSkill.PNG)

### Ejecución Skill Prompt

![Ejecución Skill Prompt](Capturas/3.5_EjecucionSkillPrompt.PNG)

### Resultado Copilot Prompt

![Resultado Copilot Prompt](Capturas/3.6_ResultadoCopilotPrompt.PNG)

### Resultado Test Despues De Prompt

![Resultado Test Despues De Prompt](Capturas/3.7_ResultadoTestDespuesDePrompt.PNG)

### Comprobación Skill Cargada

 la validación realizada para confirmar skill cargada.

![Comprobación Skill Cargada](Capturas/3.8_ComprobacionSkillCargada.PNG)

### Limpieza Transcript

![Limpieza Transcript](Capturas/3.9_LimpiezaTranscript.PNG)

### Script Apagar Task Flow

![Script Apagar Task Flow](Capturas/3.10_ScriptApagarTaskFlow.PNG)

### Prompt Ejecutado Por Agente

![Prompt Ejecutado Por Agente](Capturas/3.11_PromptEjecutadoPorAgente.PNG)

### Creación De Agentes Revisor y Tester

 la ejecución de las pruebas y el resultado obtenido.

![Creación De Agentes Revisor y Tester](Capturas/3.12_CreacionDeAgentesRevisorYTester.PNG)

### Agentes en copilot

![Agentes En Copilot](Capturas/3.13_AgentesEnCopilot.PNG)

### Prompt Revisión

 el prompt enviado para solicitar revisión.

![Prompt Revisión](Capturas/3.14_PromptRevision.PNG)

### Resultado de prompt y comprobación

 la respuesta generada por el agente tras procesar la instrucción.

![Resultado Prompt y Comprobación](Capturas/3.15_ResultadoPromptYComprobacion.PNG)

### Prompt rompelo a propósito

 la instrucción enviada para solicitar y romperlo a propósito.

![Prompt Rompelo A Propósito](Capturas/3.16_PromptRompeloAProposito.PNG)

### Prompt corregir Lo Roto

 la instrucción enviada para solicitar corregir lo roto.

![Prompt Corregir Lo Roto](Capturas/3.17_PromptCorregirLoRoto.PNG)

### Prompt Tester

 la instrucción enviada para solicitar tester.

![Prompt Tester](Capturas/3.18_PromptTester.PNG)

### Repeticion Prompt Por Error 

 repeticion Prompt por error (correccion para el error)

![Repeticion Prompt Por Error](Capturas/3.19_RepeticionPromptPorError.PNG)

### Test Arreglado

 la ejecución de las pruebas y el resultado obtenido.

![Test Arreglado](Capturas/3.20_TestArreglado.PNG)

### Limpieza y Commit

 el registro de los cambios realizados en el repositorio.

![Limpieza y Commit](Capturas/3.21_LimpiezaYCommit.PNG)

### Configuración perfil AWS

![Configuración Perfil AWS](Capturas/3.22_ConfiguracionPerfilAWS.PNG)

### Arn

![Arn](Capturas/3.23_arn.PNG)

### Copilot skill / list Skills

![Copilot Skill List3Skills](Capturas/3.24_CopilotSkillList3Skills.PNG)

### Auditoría y escritura que falla

![Auditoría y Escritura Que Falla](Capturas/3.25_AuditoriaYEscrituraQueFalla.PNG)

### Comprobación de auditoría

 la validación realizada para confirmar auditoría.

![Comprobación Auditoría](Capturas/3.26_ComprobacionAuditoria.PNG)

### Comprobación que no puede escribir

 la validación realizada para confirmar que no puede escribir.

![Comprobación Que No Puede Escribir](Capturas/3.27_ComprobacionQueNoPuedeEscribir.PNG)

### Sacar transcript y comprobación

 la validación realizada para confirmar el resultado de la actividad.

![Sacar Transcript y Comprobación](Capturas/3.28_SacarTranscriptYComprobacion.PNG)

### Romper a propósito

![Romper APropósito](Capturas/3.29_RomperAproposito.PNG)

### Resultado romper a propósito

![Resultado Romper A Propósito](Capturas/3.30_ResultadoRomperAProposito.PNG)

### Fallas en tareas

![Fallas En Tareas](Capturas/3.31_FallasEnTareas.PNG)

### Arreglado test 8 de 8

 la ejecución de las pruebas y el resultado obtenido.

![Arreglado Test8De8](Capturas/3.32_ArregladoTest8De8.PNG)

### Borrar info privada

 borrar info privada para preparar el push.

![Borrar Info Privada](Capturas/3.33_BorrarInfoPrivada.PNG)

### Comparar y PR

 la preparación o revisión de los cambios para su integración.

![Comparar y Pull Request](Capturas/3.34_CompararYPullRequest.PNG)

### Confirmar Merge


![Confirmar Merch](Capturas/3.35_ConfirmarMerch.PNG)

### Evidencia 4


![Evidencia4](Capturas/3.36_Evidencia4.PNG)

### Limpieza y encender MCP

![Limpieza Encender MCP](Capturas/3.37_LimpiezaEncenderMCP.PNG)

### Limpieza Cloud Shell

![Limpieza Cloud Shell](Capturas/3.38_LimpiezaCloudShell.PNG)

### Limpieza Terminada

![Limpieza Terminada](Capturas/3.39_LimpiezaTerminada.PNG)

## Día 5

### Academy Mty Lista

![Academy Mty Lista](Capturas/4.1_AcademyMtyLista.PNG)

### Check List antes de comenzar

![Check List Antes De Comenzar](Capturas/4.2_CheckListAntesDeComenzar.PNG)

### Instalacion extension copilot

![Instalacion Extension Copilot](Capturas/4.3_InstalacionExtensionCopilot.PNG)

### Visual con Copilot Pro

![Listo Cuando Diga Copilot Pro](Capturas/4.4_ListoCuandoDigaCopilotPro.PNG)

### Previsualizacion

![Previsualizacion](Capturas/4.5_Previsualizacion.PNG)

### Auto Completado Automatico

![Auto Completado Automatico](Capturas/4.6_AutoCompletadoAutomatico.PNG)

### Restaurar Task Service 

![Restaurado Task Service y Limpio](Capturas/4.7_RestauradoTaskServiceYLimpio.PNG)

### Inferior de visual studio configurado

![Inferior Configurado](Capturas/4.8_InferiorConfigurado.PNG)

### Prompt 1

![Prompt1](Capturas/4.9_Prompt1.PNG)

### Prompt Agent

 la instrucción enviada para solicitar agent.

![Prompt Agent](Capturas/4.10_PromptAgent.PNG)

### Run PWSH

![Run PWSH](Capturas/4.11_RunPWSH.PNG)

### Suit De Test Paso

 la ejecución de las pruebas y el resultado obtenido.

![Suit De Test Paso](Capturas/4.12_SuitDeTestPaso.PNG)

### Instructions Chat

![Instructions Chat](Capturas/4.13_InstructionsChat.PNG)

### Menu Instrucciones

![Menu Instrucciones](Capturas/4.14_MenuInstrucciones.PNG)

### Skills Menu

![Skills Menu](Capturas/4.15_SkillsMenu.PNG)

### Elegir Revisor


![Elegir Revisor](Capturas/4.16_ElegirRevisor.PNG)

### Revisor No Puede Modificar

![Revisor No Puede Modificar](Capturas/4.17_RevisorNoPuedeModificar.PNG)

### Revisar Servidores

![Revisar Servidores](Capturas/4.19_RevisarServidores.PNG)

### Arrancar API

![Arrancar API](Capturas/4.20_ArrancarAPI.PNG)

### Server Running

![Server Running](Capturas/4.21_ServerRunning.PNG)

### Herramienta Usada

![Herramienta Usada](Capturas/4.22_HerramientaUsada.PNG)

### Mismo ID

![Mismo ID](Capturas/4.23_MismoID.PNG)

### Commit y push

 el registro de los cambios realizados en el repositorio.

![Commit y Push](Capturas/4.24_CommitYPush.PNG)

### Crear nueva rama

![Crear Nueva Rama](Capturas/4.25_CrearNuevaBrench.PNG)

### Copiar MD

![Copiar MD](Capturas/4.26_CopiarMD.PNG)

### Prompt Implementar Skill

 la instrucción enviada para solicitar implementar skill.

![Prompt Implementar Skill](Capturas/4.27_PromptImplementarSkill.PNG)

### Prompt Resultado

![Prompt Resultado](Capturas/4.28_PromptResultado.PNG)

### Test Add Status

 la ejecución de las pruebas y el resultado obtenido.

![Test Add Status](Capturas/4.29_TestAddStatus.PNG)

### Revisor Con Prompt

![Revisor Con Prompt](Capturas/4.30_RevisorConPrompt.PNG)

### Resultado Prompt Revisor

![Resultado Prompt Revisor](Capturas/4.31_ResultadoPromptRevisor.PNG)

### Comprobación Prompt Revisor

![Comprobación Prompt Revisor](Capturas/4.32_ComprobacionPromptRevisor.PNG)

### Agregar Feature

![Agregar Feature](Capturas/4.33_AgregarFeature.PNG)

### Comprobación Verificador Assignee

![Comprobación Verificador Assignee](Capturas/4.34_ComprobacionVerificadorAssignee.PNG)

### Resultado prueba punta a punta

![Resultado Prueba Punta A Punta](Capturas/4.35_ResultadoPruebaPuntaAPunta.PNG)

### Commit y Push 
.

![Commit y Push Test Rest Verificar](Capturas/4.36_CommitYPushTestRestVerificar.PNG)

### PR En GitHub

 la preparación o revisión de los cambios para su integración.

![PR En GitHub](Capturas/4.37_PREnGithub.PNG)

### Copilot Request

![Columna Derecha Copilot Request](Capturas/4.38_ColumnaDerechaCopilotRequest.PNG)

### Review Copilot Git Hub

![Review Copilot Git Hub](Capturas/4.39_ReviewCopilotGitHub.PNG)

### Re-Review Copilot

![Re Review Copilot](Capturas/4.40_ReReviewCopilot.PNG)

### Re Review Copilot 2

 Comentarios de copilot en el review.

![Re Review Copilot2](Capturas/4.41_ReReviewCopilot2.PNG)

### Merge

 la integración de los cambios en la rama correspondiente.

![Merge](Capturas/4.42_Merge.PNG)

### Comprobación Merge

 la validación realizada para confirmar merge.

![Comprobación Merge](Capturas/4.43_ComprobacionMerge.PNG)

### Comprobación 

 la validación realizada para confirmar todo correcto desde PS.

![Comprobación Todo Correcto](Capturas/4.44_ComprobacionTodoCorrecto.PNG)

### Verificacion de huecos en la plantilla

![No Queda Huecos En La Plantilla](Capturas/4.45_NoQuedaHuecosEnLaPlantilla.PNG)

 ## Cierre

  - **Créditos:** En el proyecto final se usaron `10.31` AI Credits: `5.18` para implementación, `2.06` para revisión y `3.07` para correcciones. El
  registro general de septiembre indica `246.23` AI Credits, incluyendo semanas anteriores.
  - **Qué haría distinto para gastar menos:** Entregarle al agente únicamente los archivos y criterios de aceptación necesarios y haria una revisión manual antes de solicitar correcciones.

  ## Una cosa que el agente hizo mal

  El agente creó la prueba `patchAssignee_tareaDone_devuelve422` con una tarea en estado `TODO`, aunque el caso representaba una tarea terminada. 
  code review detecto el problema y tambien puso que faltaba comprobar el mensaje exacto del error `422`. al final la prueba se corrigio usando
  `TaskStatus.DONE`.