package ar.com.laboratory.candidatesapi.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Schema(description = "Error response model")
public class ErrorResponse extends BaseErrorResponse {

    @Schema(description = "Error message", example = "Invalid request")
    private String message;
}