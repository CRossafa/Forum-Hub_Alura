package forum_hub.api.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("Forum Hub API")
                        .description("API Rest da aplicação Forum Hub, contendo as funcionalidades de CRUD de usuários, cursos e tópicos.")
                        .contact(new Contact()
                                .name("Time Backend")
                                .email("backend@ONE"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://forum.hub/api/licenca")));
    }
}
