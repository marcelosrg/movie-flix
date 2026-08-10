package io.github.marcelosrg.movieflix.configuration;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        Contact contact = new Contact();
        contact.name("Marcelo");
        contact.url("https://github.com/marcelosrg");
        contact.email("marcelohenriquedev@gmail.com");

        Info info = new Info();

        info.setTitle("Movie Flix");
        info.version("1.0");
        info.description("Movie Flix - Api para gerenciamento de catalogo de filmes");
        info.contact(contact);

        return new OpenAPI().info(info);
    }
}
