package ar.com.laboratory.candidatesapi.infrastructure.controller;


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
import org.springframework.web.bind.annotation.GetMapping;

@Tag(name="Health controller", description = "Obtain information on the health of the service", externalDocs = @ExternalDocumentation(description = "Obtain information on the health of the service", url = "http://localhost:8080/health"))
public interface HealthController {
    @GetMapping
    @Operation(summary = "Obtain information on the health of the service")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "NOT FOUND", content ={@Content(schema = @Schema(implementation = ErrorResponse.class))} ),

            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                    @Content(schema = @Schema(implementation = ErrorsResponse.class))
            })
    })
    ResponseEntity<String> health();
}