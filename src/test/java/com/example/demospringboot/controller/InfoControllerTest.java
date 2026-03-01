package com.example.demospringboot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class InfoControllerTest {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.application.version}")
    private String applicationVersion;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testInfo() throws Exception {
        this.mockMvc.perform(get("/info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(this.applicationName))
                .andExpect(jsonPath("$.version").value(this.applicationVersion))
                .andExpect(jsonPath("$.instance-uuid").isNotEmpty());
    }

    @Test
    void testName() throws Exception {
        this.mockMvc.perform(get("/info/name"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(this.applicationName));
    }

    @Test
    void testVersion() throws Exception {
        this.mockMvc.perform(get("/info/version"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(this.applicationVersion));
    }
}
