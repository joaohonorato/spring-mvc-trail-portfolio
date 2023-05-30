package br.com.biblioteca;

import br.com.biblioteca.controller.IndexController;
import br.com.biblioteca.controller.PersonController;
import br.com.biblioteca.controller.ProjectController;
import br.com.biblioteca.repository.PersonRepository;
import br.com.biblioteca.repository.ProjectRepository;
import br.com.biblioteca.service.PersonService;
import br.com.biblioteca.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TestingWebApplicationTests {

    @Autowired
    private IndexController indexController;
    @Autowired
    private PersonController personController;
    @Autowired
    private ProjectController projectController;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Test
    public void contextLoads() {
        assertThat(indexController).isNotNull();
        assertThat(personController).isNotNull();
        assertThat(projectController).isNotNull();
        assertThat(projectService).isNotNull();
        assertThat(personService).isNotNull();
        assertThat(personRepository).isNotNull();
        assertThat(projectRepository).isNotNull();
    }

}