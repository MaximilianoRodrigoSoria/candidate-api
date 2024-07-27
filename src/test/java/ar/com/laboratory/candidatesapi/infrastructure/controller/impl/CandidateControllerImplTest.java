package ar.com.laboratory.candidatesapi.infrastructure.controller.impl;

import ar.com.laboratory.candidatesapi.application.service.CandidateService;
import ar.com.laboratory.candidatesapi.domain.CandidateRequest;
import ar.com.laboratory.candidatesapi.domain.CandidateResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import ar.com.laboratory.candidatesapi.util.Data;

@WebMvcTest(CandidateControllerImpl.class)
public class CandidateControllerImplTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CandidateService candidateService;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("When createCandidate is invoked then return a valid response")
    void createCandidate() throws Exception {
        // Assemble
        CandidateRequest candidateRequest = Data.CANDIDATE_REQUEST;
        CandidateResponse candidateResponse = Data.CANDIDATE_RESPONSE;

        when(candidateService.created(any(CandidateRequest.class))).thenReturn(candidateResponse);

        // Act & Assert
        mvc.perform(post("/api/v1/candidate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(candidateRequest)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"))
                .andExpect(jsonPath("$.gender").value("Male"))
                .andExpect(jsonPath("$.expectedSalary").value(60000))
                .andExpect(jsonPath("$.active").value(true))
                .andExpect(jsonPath("$.typeOfContract").value("Full-time"));
    }

    @Test
    @DisplayName("When getCandidate is invoked then return a valid response")
    void getCandidate() throws Exception {
        // Assemble
        CandidateResponse candidateResponse = Data.CANDIDATE_RESPONSE;

        when(candidateService.read(1L)).thenReturn(candidateResponse);

        // Act & Assert
        mvc.perform(get("/api/v1/candidate/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"))
                .andExpect(jsonPath("$.gender").value("Male"))
                .andExpect(jsonPath("$.expectedSalary").value(60000))
                .andExpect(jsonPath("$.active").value(true))
                .andExpect(jsonPath("$.typeOfContract").value("Full-time"));
    }

    @Test
    @DisplayName("When updateCandidate is invoked then return a valid response")
    void updateCandidate() throws Exception {
        // Assemble
        CandidateRequest candidateRequest = Data.CANDIDATE_REQUEST;
        CandidateResponse candidateResponse = Data.CANDIDATE_RESPONSE;

        when(candidateService.update(any(CandidateRequest.class), Mockito.eq(1L))).thenReturn(candidateResponse);

        // Act & Assert
        mvc.perform(put("/api/v1/candidate/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(candidateRequest)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"))
                .andExpect(jsonPath("$.gender").value("Male"))
                .andExpect(jsonPath("$.expectedSalary").value(60000))
                .andExpect(jsonPath("$.active").value(true))
                .andExpect(jsonPath("$.typeOfContract").value("Full-time"));
    }

    @Test
    @DisplayName("When deleteCandidate is invoked then return a valid response")
    void deleteCandidate() throws Exception {
        // Act & Assert
        mvc.perform(delete("/api/v1/candidate/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("When getCandidates is invoked then return a valid response")
    void getCandidates() throws Exception {
        // Assemble
        List<CandidateResponse> candidates = Arrays.asList(Data.CANDIDATE_RESPONSE, Data.CANDIDATE_RESPONSE);

        when(candidateService.readAll()).thenReturn(candidates);

        // Act & Assert
        mvc.perform(get("/api/v1/candidate")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[0].email").value("john.doe@example.com"))
                .andExpect(jsonPath("$[0].gender").value("Male"))
                .andExpect(jsonPath("$[0].expectedSalary").value(60000))
                .andExpect(jsonPath("$[0].active").value(true))
                .andExpect(jsonPath("$[0].typeOfContract").value("Full-time"))
                .andExpect(jsonPath("$[1].id").value(1L))
                .andExpect(jsonPath("$[1].name").value("John Doe"))
                .andExpect(jsonPath("$[1].email").value("john.doe@example.com"))
                .andExpect(jsonPath("$[1].gender").value("Male"))
                .andExpect(jsonPath("$[1].expectedSalary").value(60000))
                .andExpect(jsonPath("$[1].active").value(true))
                .andExpect(jsonPath("$[1].typeOfContract").value("Full-time"))
                .andExpect(jsonPath("$", hasSize(2)));
    }
}