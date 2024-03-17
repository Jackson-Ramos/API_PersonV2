package com.facisa.springboot.confg;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfg {
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						// Titulo da API
						.title("Cadastro de funcionarios")
						// verssão da API
						.version("1.0.0")
						// Descriçãonda API
						.description("Cadastra novos funcionarios e atualisa os mais antigos")
						// Link pos termos de serviço
						.termsOfService("https://dev.com.br")
						.license(
								new License()
										//nome descritivo da licença
										.name("dev_jr")
										// url para adiquirir a licença
										.url("https://dev.com.br")
						)
				);
	}
}
