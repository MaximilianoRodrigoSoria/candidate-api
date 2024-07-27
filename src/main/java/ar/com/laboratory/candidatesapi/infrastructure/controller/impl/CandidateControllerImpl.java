package ar.com.laboratory.candidatesapi.infrastructure.controller.impl;


import ar.com.laboratory.candidatesapi.application.service.CandidateService;
import ar.com.laboratory.candidatesapi.domain.CandidateRequest;
import ar.com.laboratory.candidatesapi.domain.CandidateResponse;
import ar.com.laboratory.candidatesapi.infrastructure.controller.CandidateController;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/candidate")
@AllArgsConstructor
@Slf4j
public class CandidateControllerImpl implements CandidateController {

    private final CandidateService candidateService;

    @Override
    @PostMapping
    public ResponseEntity<CandidateResponse> createCandidate(@Valid @RequestBody CandidateRequest candidateRequest) {
        var candidateResponse = candidateService.created(candidateRequest);
        return ResponseEntity.ok(candidateResponse);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CandidateResponse> getCandidate(@PathVariable("id") Long id) {
        var candidateResponse = candidateService.read(id);
        return ResponseEntity.ok(candidateResponse);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<CandidateResponse> updateCandidate(@PathVariable("id") Long id, @Valid @RequestBody CandidateRequest candidateRequest) {
        var candidateResponse = candidateService.update(candidateRequest, id);
        return ResponseEntity.ok(candidateResponse);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable("id") Long id) {
        candidateService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CandidateResponse>> getCandidates() {
        var candidateResponse = candidateService.readAll();
        return ResponseEntity.ok(candidateResponse);
    }
}
