package ar.com.laboratory.candidatesapi.infrastructure.controller;


import ar.com.laboratory.candidatesapi.domain.CandidateRequest;
import ar.com.laboratory.candidatesapi.domain.CandidateResponse;
import ar.com.laboratory.candidatesapi.domain.ErrorResponse;
import ar.com.laboratory.candidatesapi.domain.ErrorsResponse;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name="Candidate controller", description = "Obtain information on the candidate of the service", externalDocs = @ExternalDocumentation(description = "Obtain information on the health of the service", url = "http://localhost:8080/health"))
public interface CandidateController {

    @Operation(summary = "Create a new candidate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Candidate deleted successfully",content = @Content(schema = @Schema(implementation = CandidateResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrorsResponse.class))),
            @ApiResponse(responseCode = "404", description = "Candidate not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorsResponse.class)))
    })
    public ResponseEntity<CandidateResponse> createCandidate(CandidateRequest candidateRequest);

    @Operation(summary = "Get a candidate by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Candidate retrieved successfully", content = @Content(schema = @Schema(implementation = CandidateResponse.class))),
            @ApiResponse(responseCode = "404", description = "Candidate not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<CandidateResponse> getCandidate(Long id);

    @Operation(summary = "Update a candidate by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Candidate deleted successfully",content = @Content(schema = @Schema(implementation = CandidateResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrorsResponse.class))),
            @ApiResponse(responseCode = "404", description = "Candidate not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorsResponse.class)))
    })
    public ResponseEntity<CandidateResponse> updateCandidate(Long id, CandidateRequest candidateRequest);

    @Operation(summary = "Delete a candidate by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Candidate deleted successfully",content = @Content(schema = @Schema(implementation = CandidateResponse.class))),
            @ApiResponse(responseCode = "404", description = "Candidate not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<Void> deleteCandidate(Long id);

@Operation(summary = "Get all candidates")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Candidates retrieved successfully", content = @Content(schema = @Schema(implementation = CandidateResponse[].class))),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
})
public ResponseEntity<List<CandidateResponse>> getCandidates();
}