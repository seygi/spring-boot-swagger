package com.example.springbootswagger.unit.controller;


import com.example.springbootswagger.controller.BrexController;
import com.example.springbootswagger.model.brex.BrexItemResponse;
import com.example.springbootswagger.model.brex.BrexResponse;
import com.example.springbootswagger.service.BrexService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BrexControllerTest {
    private MockMvc mockMvc;

    @Mock
    private BrexService brexService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new BrexController(brexService)).build();
    }

    @Test
    public void testGetBrex_NoResults() throws Exception {
        // Set up mock data
        BrexResponse brexResponse = new BrexResponse();
        brexResponse.setData(new ArrayList<>());

        // Set up mock service
        when(brexService.brexRequestUsingLibrariesFromEmail()).thenReturn(brexResponse);

        // Make request and verify response
        mockMvc.perform(get("/api/v1/brex"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data", hasSize(0)));
    }

    @Test
    public void testGetBrex_WithResults() throws Exception {
        // Set up mock data
        BrexItemResponse brexItemResponse1 = new BrexItemResponse();
        brexItemResponse1.setCompany("Brex");
        brexItemResponse1.setCreatedAt(ZonedDateTime.now());
        brexItemResponse1.setName("John Doe");

        BrexItemResponse brexItemResponse2 = new BrexItemResponse();
        brexItemResponse2.setCompany("Acme");
        brexItemResponse2.setCreatedAt(ZonedDateTime.now());
        brexItemResponse2.setName("Jane Smith");

        List<BrexItemResponse> brexItemResponses = new ArrayList<>();
        brexItemResponses.add(brexItemResponse1);
        brexItemResponses.add(brexItemResponse2);

        BrexResponse brexResponse = new BrexResponse();
        brexResponse.setData(brexItemResponses);

        // Set up mock service
        when(brexService.brexRequestUsingLibrariesFromEmail()).thenReturn(brexResponse);

        // Make request and verify response
        MvcResult result = mockMvc.perform(get("/api/v1/brex"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data", hasSize(2)))
                .andExpect(jsonPath("$.data[0].company", is("Brex")))
                .andExpect(jsonPath("$.data[0].name", is("John Doe")))
                .andExpect(jsonPath("$.data[1].company", is("Acme")))
                .andExpect(jsonPath("$.data[1].name", is("Jane Smith")))
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();

        // Convert the JSON string to a BrexResponse object
        BrexResponse newBrexResponse = new Gson().fromJson(responseBody, BrexResponse.class);

        // Verify that the response contains the expected data
        List<BrexItemResponse> newBrexItemResponse = brexResponse.getData();
        assertEquals(2, newBrexItemResponse.size());

        BrexItemResponse newBrexItemResponse1 = newBrexItemResponse.get(0);
        assertEquals("Brex", newBrexItemResponse1.getCompany());
        assertEquals("John Doe", newBrexItemResponse1.getName());

        BrexItemResponse newBrexItemResponse2 = newBrexItemResponse.get(1);
        assertEquals("Acme", newBrexItemResponse2.getCompany());
        assertEquals("Jane Smith", newBrexItemResponse2.getName());
    }
}