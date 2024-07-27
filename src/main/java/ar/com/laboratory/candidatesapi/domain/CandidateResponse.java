package ar.com.laboratory.candidatesapi.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Schema(description = "Candidate response model")
@AllArgsConstructor
public class CandidateResponse {

    @Schema(description = "ID of the candidate", example = "1")
    private Long id;

    @Schema(description = "Name of the candidate", example = "John Doe")
    private String name;

    @Schema(description = "Email of the candidate", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Gender of the candidate", example = "Male")
    private String gender;

    @Schema(description = "Expected salary of the candidate", example = "60000.00")
    private BigDecimal expectedSalary;

    @Schema(description = "Whether the candidate is active", example = "true")
    private Boolean active;

    @Schema(description = "Date when the candidate was created", example = "2023-01-01T00:00:00Z")
    private Date createdAt;

    @Schema(description = "Date when the candidate was last updated", example = "2023-10-01T00:00:00Z")
    private Date updatedAt;

    @Schema(description = "Type of contract of the candidate", example = "Full-time")
    private String typeOfContract;
}