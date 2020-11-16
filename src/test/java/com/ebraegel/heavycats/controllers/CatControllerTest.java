package com.ebraegel.heavycats.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ebraegel.heavycats.contoller.CatController;
import com.ebraegel.heavycats.jpa.repository.CatRepository;
import com.ebraegel.heavycats.model.Cat;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CatController.class)
public class CatControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    CatRepository catRepository;

    @Test
    public void shouldGetCatsAndReturn200() throws Exception {
        mockMvc.perform(get("/cats")).andExpect(status().isOk());
    }

    @Test
    public void shouldCreateACat() throws Exception {
        Cat cat = new Cat(123L, "Pancake");

        mockMvc.perform(post("/cats")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(cat)))
                .andExpect(status().isOk());
    }

    // TODO: This... doesn't work. Learn how to test controllers!
    @Test
    public void shouldFailToCreateACatWhenNameIsNull() throws Exception {
        mockMvc.perform(post("/cats")
                .contentType("application/json")
                .content("{}"))
                .andExpect(status().isBadRequest());
    }
}
