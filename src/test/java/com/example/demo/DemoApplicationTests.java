package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootApplication
public class DemoApplicationTests {

    private MockMvc mockMvc;

    @Before
    public void setUp()throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(new DemoApplicationTests()).build();
    }

    @Test
    public void contextLoads()throws Exception {

    }

}
