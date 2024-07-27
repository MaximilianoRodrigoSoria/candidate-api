package ar.com.laboratory.candidatesapi.infrastructure.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OpenApiConfig
{    @Bean
public OpenAPI customOpenAPI(
        @Value("${open.api.info.build.version}") String version,
        @Value("${open.api.contact.info.name}") String contactName,
        @Value("${open.api.contact.info.email}") String contactEmail,
        @Value("${open.api.contact.info.url}") String contactUrl,
        @Value("${open.api.contact.info.title}") String title,
        @Value("${open.api.licence.name}") String license,
        @Value("${open.api.licence.url}") String licenseUrl,
        @Value("${open.api.contact.info.description}") String description,
        @Value("${open.api.server.url}") String hostUrl,
        @Value("${open.api.server.description}")String hostDescription,
        @Value("${open.api.external.doc.url}")String externalDoc,
        @Value("${open.api.external.doc.description}") String externalDocDescription
) {
    return new OpenAPI()
            .components(new Components()
                    .addSecuritySchemes("basicScheme", new SecurityScheme().type(SecurityScheme.Type.HTTP)
                            .scheme("basic")))
            .info(new Info()
                    .title(title)
                    .description(description)
                    .contact(new Contact().name(contactName).email(contactEmail).url(contactUrl))
                    .version(version)
                    .license(new License().name(license).url(licenseUrl)))
            .externalDocs(new ExternalDocumentation()
                    .description(externalDocDescription)
                    .url(externalDoc));
}
    @Bean
    public GroupedOpenApi candidateApi() {
        return GroupedOpenApi.builder()
                .group("candidate-api")
                .pathsToMatch("/api/v1/candidate/**")
                .build();
    }



    @Bean
    public GroupedOpenApi allPlanetApi() {
        return GroupedOpenApi.builder()
                .group("all")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    public GroupedOpenApi planetGroupApi() {
        return GroupedOpenApi.builder()
                .group("health-api")
                .pathsToMatch("/api/v1/health/**")
                .build();
    }
}