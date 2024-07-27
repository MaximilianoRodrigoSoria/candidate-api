package ar.com.laboratory.candidatesapi.application.service.impl;


import ar.com.laboratory.candidatesapi.application.repository.CandidateRepository;
import ar.com.laboratory.candidatesapi.application.service.CandidateService;
import ar.com.laboratory.candidatesapi.infrastructure.exceptions.IdNotFoundException;
import ar.com.laboratory.candidatesapi.infrastructure.mapper.CandidateMapper;
import ar.com.laboratory.candidatesapi.util.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ar.com.laboratory.candidatesapi.infrastructure.exceptions.*;
import ar.com.laboratory.candidatesapi.infrastructure.util.Constants;
@ContextConfiguration(classes = {CandidateServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CandidateServiceImplTest {

    @BeforeEach
    void setUp() {
    }

    @Autowired
    private CandidateService candidateService;

    @MockBean
    private CandidateRepository candidateRepository;

    @MockBean
    private CandidateMapper mapper;

    @Test
    @DisplayName("Searching for a candidate list is tested")
    void readAll() {
        //ASSEMBLE
        var expected = "John Doe";
        when(candidateRepository.findByActiveTrue()).thenReturn(Data.CANDIDATE_LIST);
        when(mapper.toResponse(any())).thenReturn(Data.CANDIDATE_RESPONSE);

        //ACT
        var candidates = candidateService.readAll();

        //ASSERT
        assertAll(
                () -> assertNotNull(candidates),
                () -> assertEquals(expected, candidates.get(0).getName())
        );
    }

    @Test
    @DisplayName("Create a candidate is tested")
    void created() {
        //ASSEMBLE
        var expected = "John Doe";
        when(candidateRepository.save(any())).thenReturn(Data.CANDIDATE_1);
        when(mapper.toResponse(any())).thenReturn(Data.CANDIDATE_RESPONSE);

        //ACT
        var candidate = candidateService.created(Data.CANDIDATE_REQUEST);

        //ASSERT
        assertAll(
                () -> assertNotNull(candidate),
                () -> assertEquals(expected, candidate.getName()));
    }

    @Test
    @DisplayName("Create a candidate and fail is tested")
    void createdException() {
        // ASSEMBLE
        var expected = "Record saving in candidates";
        when(candidateRepository.save(any())).thenThrow(new SaveException(Constants.CANDIDATE_TABLE));

        // ACT and ASSERT
        SaveException exception = assertThrows(SaveException.class, () -> {
            candidateService.created(Data.CANDIDATE_REQUEST);
        });


        String result = exception.getMessage();
        assertEquals(expected, result);
    }

        @Test
        @DisplayName("Read a candidate is tested")
        void read() {
            //ASSEMBLE
            var expected = "John Doe";
            when(candidateRepository.findByIdAndActiveTrue(any())).thenReturn(Optional.of(Data.CANDIDATE_1));
            when(mapper.toCandidate(any())).thenReturn(Data.CANDIDATE_1);

            //ACT
            var candidate = candidateService.read(1L);

            //ASSERT
            assertNotNull(candidate);
            assertEquals(expected,candidate.getName());
        }

        @Test
        @DisplayName("Read a candidate fail is tested")
        void readFail() {
            //ASSEMBLE
            var expected = "Record no exist in candidates";
            when(candidateRepository.findByIdAndActiveTrue(any())).thenThrow(new IdNotFoundException(Constants.CANDIDATE_TABLE));

            // ACT and ASSERT
            var exception = assertThrows(IdNotFoundException.class, () -> candidateService.read(120L));
            String result = exception.getMessage();
            assertEquals(expected, result);
        }


        @Test
        @DisplayName("Updated a candidate is tested")
        void update() {
            //ASSEMBLE
           var expected = "John Doe";
           when(candidateRepository.findByIdAndActiveTrue(any())).thenReturn(Optional.of(Data.CANDIDATE_1));
           when(mapper.toResponse(any())).thenReturn(Data.CANDIDATE_RESPONSE);
           when(candidateRepository.save(any())).thenReturn(Data.CANDIDATE_1);

            //ACT
            var candidate = candidateService.update(Data.CANDIDATE_REQUEST, 1L);

            //ASSERT
            assertNotNull(candidate);
            assertEquals(expected,candidate.getName());
        }


        @Test
        @DisplayName("Update a candidate fail is tested")
        void updateFail() {
            //ASSEMBLE
            var expected = "Record no exist in candidates";
            when(candidateRepository.findAllById(any())).thenThrow(new IdNotFoundException(Constants.CANDIDATE_TABLE));

            // ACT and ASSERT
            var exception = assertThrows(IdNotFoundException.class, () -> candidateService.update(Data.CANDIDATE_REQUEST, 120L));
            String result = exception.getMessage();
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Delete a candidate is tested")
        void delete() {
            //ASSEMBLE
            when(candidateRepository.findByIdAndActiveTrue(any())).thenReturn(Optional.of(Data.CANDIDATE_1));

            //ACT
            candidateService.delete(1L);

            //ASSERT
            verify(candidateRepository).findByIdAndActiveTrue(1L);

        }

    }


