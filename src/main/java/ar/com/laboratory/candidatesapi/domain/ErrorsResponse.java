package ar.com.laboratory.candidatesapi.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Schema(description = "Errors response model")
public class ErrorsResponse extends BaseErrorResponse {

    @Schema(description = "List of error messages", example = "[\"Error 1\", \"Error 2\"]")
    private List<String> errors;
}