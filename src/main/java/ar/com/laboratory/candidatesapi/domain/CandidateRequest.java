package ar.com.laboratory.candidatesapi.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Schema(description = "Candidate request model")
public class CandidateRequest {

    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name must be less than or equal to 100 characters")
    @Schema(description = "Name of the candidate", example = "John Doe")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @Size(max = 100, message = "Email must be less than or equal to 100 characters")
    @Schema(description = "Email of the candidate", example = "john.doe@example.com")
    private String email;

    @Size(max = 10, message = "Gender must be less than or equal to 10 characters")
    @Schema(description = "Gender of the candidate", example = "Male")
    private String gender;

    @NotNull(message = "Expected salary is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Expected salary must be greater than zero")
    @Digits(integer = 10, fraction = 2, message = "Expected salary must be a valid monetary amount")
    @Schema(description = "Expected salary of the candidate", example = "60000.00")
    private BigDecimal expectedSalary;

    @Size(max = 50, message = "Type of contract must be less than or equal to 50 characters")
    @Schema(description = "Type of contract of the candidate", example = "Full-time")
    private String typeOfContract;
}