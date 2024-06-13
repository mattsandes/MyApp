package br.com.sandes.MyApi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    //criando o metodo que vai configurar o swagger da minha api
    @Bean //= um objeto que é genrenciado pelo spring
    public OpenAPI customOpenApi(){

        return new OpenAPI()
                .info(new Info()
                        .title("My Api")
                        .version("v1")
                        .description("Essa é uma api que eu criei por minha conta")
                        .termsOfService("")
                        .license(new License().name("Apache 2.0")
                                .url("https://github.com/mattsandes/My-API/tree/master")
                        )
                );
    }
}
