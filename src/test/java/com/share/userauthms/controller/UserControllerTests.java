package com.share.userauthms.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
class UserControllerTests {

    MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    void testGetUserByIdRequest() throws Exception {
        // static import of MockMvcRequestBuilders.* and MockMvcResultMatchers.*
        mockMvc.perform(get("/users/1"))
                // Check status returned
                .andExpect(status().isOk())
                // Verify json content
                .andExpect(jsonPath("$.userName").value("devonte"));

    }

    @Test
    void testGetUsersRequest() throws Exception {
        // static import of MockMvcRequestBuilders.* and MockMvcResultMatchers.*
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk());

    }

}
