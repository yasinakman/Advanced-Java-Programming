package com.akman.springbootdemo.rest_api.controller;

import com.akman.springbootdemo.service.advancedservice.AdvancedJavaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@WebMvcTest(AdvancedJavaController.class)
@RunWith(PowerMockRunner.class)
public class AdvancedJavaControllerTest {

    private static final String ADVANCED_JAVA_ENDPOINT = "/api/v1/advanced-java/";

    private MockMvc mvc;

    private ObjectMapper objectMapper;

    @Mock
    private AdvancedJavaService advancedJavaService;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
        mvc = MockMvcBuilders
                .standaloneSetup(new AdvancedJavaController(advancedJavaService))
                .build();
    }

    @Test
    public void test() {

    }
}