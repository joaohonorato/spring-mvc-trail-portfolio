package br.com.biblioteca.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(IndexController.class)
class IndexControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnIndex() throws Exception {
        this.mockMvc
            .perform(get("/"))
            .andExpect(status().is(200))
            .andExpect(view().name("index"));
    }
  
}