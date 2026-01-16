package ru.maltsev.simplecrud.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class OpenAPIConfig {

    private final Environment environment;

    @Bean
    public OpenAPI defineOpenAPI () {
        Server server = new Server();
        String serverUrl = environment.getProperty("api.server.url");
        server.setUrl(serverUrl);
        server.setDescription("Production");

        Contact myContact = new Contact();
        myContact.setName("Мальцев Кирилл");
        myContact.setEmail("opp.2211@gmail.com");

        Info info = new Info()
                .title("Simple-crud API")
                .version("1.0")
                .description("Это тестовое API предоставляет тестовые эндпоинты для управления тестовыми сущностями. " +
                        "Проект создан с целью отработки знаний на практике")
                .contact(myContact);

        return new OpenAPI()
                .info(info)
                .servers(List.of(server));
    }

}
