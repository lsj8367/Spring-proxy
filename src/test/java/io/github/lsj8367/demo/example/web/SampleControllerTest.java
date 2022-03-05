package io.github.lsj8367.demo.example.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import io.github.lsj8367.demo.example.configuration.LoggingAspect;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Import(LoggingAspect.class)
@WebMvcTest(SampleController.class)
class SampleControllerTest {

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext ctx;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
            .alwaysDo(print())
            .build();
    }

    @Test
    @DisplayName("hello Controller 테스트")
    void helloTest() throws Exception {
        mockMvc.perform(get("/api/v1/hello"))
            .andExpect(status().isOk());
    }

    @Test
    @DisplayName("around aop 테스트")
    void aroundTest() throws Exception {
        mockMvc.perform(get("/api/v1/around"))
            .andExpect(status().isOk());
    }
}