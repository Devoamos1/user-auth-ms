package com.share.userauthms.controller;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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

    @Test
    void testCreateUser() throws Exception{
        // static import of MockMvcRequestBuilders.*

        // Given
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userName", "devoamos");
        String expectedResponse = "User created";

        // When
        mockMvc.perform(post("/users").accept(MediaType.APPLICATION_JSON)
                        .content(jsonObject.toString()))
                .andExpect(status().is2xxSuccessful())
                //Then
                .andExpect(content().string(expectedResponse));




    }


}

//
// Future implementation
//@WebMvcTest(YourController.class)
//public class YourControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper; // Autowire ObjectMapper
//
//    @Test
//    void testPostRequest() throws Exception {
//        // Create an instance of your request object
//        YourRequestObject requestObject = new YourRequestObject();
//        requestObject.setField1("value1");
//        requestObject.setField2("value2");
//
//        // Serialize the request object to a JSON string
//        String requestBody = objectMapper.writeValueAsString(requestObject);
//
//        // Perform the POST request and assert the response
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/your-endpoint")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestBody))
//                .andExpect(status().isOk())
//                .andExpect(content().json("{\"message\": \"success\"}")); // Example response assertion
//    }
//}