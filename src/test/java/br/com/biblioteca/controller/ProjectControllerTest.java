package br.com.biblioteca.controller;

import br.com.biblioteca.model.dto.PersonDTO;
import br.com.biblioteca.model.dto.ProjectDTO;
import br.com.biblioteca.model.enums.RiskEnum;
import br.com.biblioteca.model.enums.StatusEnum;
import br.com.biblioteca.model.vo.CpfVO;
import br.com.biblioteca.service.PersonService;
import br.com.biblioteca.service.ProjectService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static br.com.biblioteca.constants.Constants.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(ProjectController.class)
class ProjectControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectService projectService;

    @MockBean
    private PersonService personService;

    @Test
    @DisplayName("ProjectController.list - List projects")
    public void whenFindAllProjectshouldReturnProjectList() throws Exception {
        when(projectService.findAll()).thenReturn(List.of());
        this.mockMvc
            .perform(get("/project/list"))
            .andExpect(status().is(200))
            .andExpect(model().attributeExists(PROJECT_LIST_ATTR))
            .andExpect(view().name(PROJECT_LIST_VIEW));
    }

    @Test
    @DisplayName("ProjectController.add - Form add project")
    public void whenAddProjectshouldReturnProjectForm() throws Exception {
        when(personService.findEmployees()).thenReturn(List.of());
        this.mockMvc
                .perform(get("/project/add"))
                .andExpect(status().is(200))
                .andExpect(model().attributeExists(PROJECT_ATTR))
                .andExpect(model().attributeExists(STATUS_LIST_ATTR))
                .andExpect(model().attributeExists(RISK_LIST_ATTR))
                .andExpect(model().attributeExists(MANAGER_LIST_ATTR))
                .andExpect(view().name(PROJECT_FORM_VIEW));
    }

    @Test
    @DisplayName("ProjectController.edit - Form edit project")
    public void whenEditProjectshouldReturnProjectForm() throws Exception {
        when(personService.findEmployees()).thenReturn(List.of());
        when(projectService.find(anyLong())).thenReturn(new ProjectDTO());
        this.mockMvc
                .perform(get("/project/1"))
                .andExpect(status().is(200))
                .andExpect(model().attributeExists(PROJECT_ATTR))
                .andExpect(model().attributeExists(STATUS_LIST_ATTR))
                .andExpect(model().attributeExists(RISK_LIST_ATTR))
                .andExpect(model().attributeExists(MANAGER_LIST_ATTR))
                .andExpect(view().name(PROJECT_FORM_VIEW));
    }

    @Test
    @DisplayName("ProjectController.merge - Form merge project")
    public void whenMergeProjectshouldReturnProjecList() throws Exception {
        when(personService.findEmployees()).thenReturn(List.of());
        when(projectService.merge(any())).thenReturn(new ProjectDTO());
        PersonDTO personDTO = new PersonDTO(1L, "name", LocalDate.now(), new CpfVO("97564388865"), true);
        ProjectDTO projectDTO = new ProjectDTO(1L, "name", LocalDate.now(), LocalDate.now(), LocalDate.now(), "description", StatusEnum.DONE, BigDecimal.ONE, RiskEnum.ALTO_RISCO, 1L, personDTO);
        this.mockMvc
                .perform(post("/project/1").flashAttr("project",projectDTO))
                .andExpect(status().is(302))
                .andExpect(flash().attributeExists(PROJECT_LIST_ATTR))
                .andExpect(redirectedUrl("/project/list"));
    }
  
}