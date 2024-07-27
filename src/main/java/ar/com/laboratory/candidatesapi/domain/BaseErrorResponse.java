package ar.com.laboratory.candidatesapi.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class BaseErrorResponse {

    @Schema(description = "Status of the error response", example = "error")
    private String status;

    @Schema(description = "Error code", example = "400")
    private Integer code;
}