package com.ing.vacancy.codingchallenge;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest()
@AutoConfigureMockMvc
class CodingChallengeApplicationTests {

    @Resource
    private MockMvc mockMvc;

    @SneakyThrows
    @Test
    public void testGetUserDetails(){
        this.mockMvc.perform(get("/api/userdetails/1").with(user("leonr").password("password")))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"firstName\":\"Leon\",\"lastName\":\"Russell\",\"gender\":\"male\",\"title\":\"Mr.\",\"address\":{\"street\":\"12 Insignia Way\",\"city\":\"Yilkari\",\"state\":\"Western Australia\",\"postcode\":6430}}"));
    }

    @SneakyThrows
    @Test
    public void testPutUserDetails(){
        this.mockMvc.perform(
                    put("/api/userdetails/2")
                    .with(user("leonr").password("password").roles("ADMIN"))
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\"title\":\"Dr\"}")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

}
