package ar.com.laboratory.candidatesapi.infrastructure.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Candidate API",
                version = "1.0",
                description = "Documentation for endpoints in Candidate API")
)
public class OpenApiConfig {
}
