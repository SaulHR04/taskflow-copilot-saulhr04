package com.taskflow.unit;

import com.taskflow.dto.ProjectSummaryResponse;
import com.taskflow.model.Priority;
import com.taskflow.model.Project;
import com.taskflow.model.Task;
import com.taskflow.model.TaskStatus;
import com.taskflow.repository.ProjectRepository;
import com.taskflow.repository.TaskRepository;
import com.taskflow.repository.UserRepository;
import com.taskflow.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectSummaryServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ProjectService service;

    private final Project proyecto = new Project(2L, "App Móvil", "d", 1L, null);

    @Test
    void resumen_proyectoConTareas_yUnaVencida() throws Exception {
        // tareas: TODO x1, IN_PROGRESS x2, DONE x1; una de las IN_PROGRESS está vencida
        Task t1 = new Task(5L, "T01", "d", TaskStatus.TODO, Priority.MED, 2L, null, null);
        Task t2 = new Task(6L, "T02", "d", TaskStatus.IN_PROGRESS, Priority.MED, 2L, 1L, LocalDate.now().minusDays(2));
        Task t3 = new Task(7L, "T03", "d", TaskStatus.IN_PROGRESS, Priority.MED, 2L, 2L, LocalDate.now().plusDays(2));
        Task t4 = new Task(8L, "T04", "d", TaskStatus.DONE, Priority.MED, 2L, 1L, LocalDate.now().minusDays(5));

        when(taskRepository.findByProjectId(2L)).thenReturn(List.of(t1, t2, t3, t4));

        ProjectSummaryResponse expected = new ProjectSummaryResponse(2L, "App Móvil", 4,
                java.util.Map.of("TODO", 1L, "IN_PROGRESS", 2L, "DONE", 1L), 1L);

        assertEquals(expected, service.resumen(proyecto));
    }

    @Test
    void resumen_proyectoSinTareas_devuelveCeros() {
        when(taskRepository.findByProjectId(3L)).thenReturn(List.of());
        Project p3 = new Project(3L, "Vacío", "d", 1L, null);

        ProjectSummaryResponse expected = new ProjectSummaryResponse(3L, "Vacío", 0,
                java.util.Map.of("TODO", 0L, "IN_PROGRESS", 0L, "DONE", 0L), 0L);

        assertEquals(expected, service.resumen(p3));
    }
}
