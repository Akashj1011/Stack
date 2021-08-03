package com.example.stack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(StackController.class)
public class StackControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void integrationTest() throws Exception {
        mockMvc.perform(post("/create" )
            .contentType(MediaType.APPLICATION_JSON)
        .param("size", String.valueOf(5)))
            .andExpect(status().isOk());

        mockMvc.perform(post("/push/" + 1)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
            "/peek").accept(
            MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String peekElement = result.getResponse().getContentAsString();
        assertThat(peekElement).isEqualTo("1");

        requestBuilder = MockMvcRequestBuilders.get(
            "/pop").accept(
            MediaType.APPLICATION_JSON);

        result = mockMvc.perform(requestBuilder).andReturn();
        String popedElement = result.getResponse().getContentAsString();
        assertThat(popedElement).isEqualTo("1");

        mockMvc.perform(get("/pop")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());

        mockMvc.perform(post("/push/" + 5)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

        mockMvc.perform(post("/push/" + 7)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

        requestBuilder = MockMvcRequestBuilders.get(
            "/size").accept(
            MediaType.APPLICATION_JSON);

        result = mockMvc.perform(requestBuilder).andReturn();
        String size = result.getResponse().getContentAsString();
        assertThat(size).isEqualTo("2");

        mockMvc.perform(get("/pop")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

        mockMvc.perform(get("/pop")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

        requestBuilder = MockMvcRequestBuilders.get(
            "/empty").accept(
            MediaType.APPLICATION_JSON);

        result = mockMvc.perform(requestBuilder).andReturn();
        String isEmpty = result.getResponse().getContentAsString();
        assertThat(isEmpty).isEqualTo("true");

    }

}
