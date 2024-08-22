package br.com.sandes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	@Bean
	OpenAPI customOpenApi() {
		return new OpenAPI()
				.info(new Info()
						.title("Personal API")
						.version("v1")
						.description("Api criada para praticar com CI/CD")
						.termsOfService("http://localhost:8080")
						.license(new License().name("Apache 2.0")
								.url("http://localhost:8080")));
	}
}
