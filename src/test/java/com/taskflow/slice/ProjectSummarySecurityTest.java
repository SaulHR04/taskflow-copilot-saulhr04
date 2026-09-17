package com.taskflow.slice;

import com.taskflow.controller.ProjectController;
import com.taskflow.security.JwtAuthenticationFilter;
import com.taskflow.security.JwtService;
import com.taskflow.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test slice que verifica la seguridad del endpoint GET /projects/{id}/summary: debe devolver 401
 * cuando se llama sin token.
 */
@WebMvcTest(ProjectController.class)
@AutoConfigureMockMvc // filtros de seguridad activos
@Import(JwtAuthenticationFilter.class) // incluir el filtro real, pero mockear sus dependencias
class ProjectSummarySecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectService projectService; // controller depende de este service

    @MockBean
    private JwtService jwtService; // dependencia del filtro

    @MockBean
    private UserDetailsService userDetailsService; // dependencia del filtro

    @Test
    void getSummary_sinToken_devuelve401() throws Exception {
        mockMvc.perform(get("/projects/2/summary"))
                .andExpect(status().isUnauthorized());
    }
}
