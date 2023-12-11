package com.manuboo.pruebaTecnica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class PruebaTecnicaW2MApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaTecnicaW2MApplication.class, args);
	}
	
	 @Bean
	    public OpenAPI customOpenAPI() {
	        return new OpenAPI()
	                .info(new Info()
	                        .title("API SuperHeroes")
	                        .version("1.0")
	                        .description("API SuperHeroes para prueba tecnica de W2M")
	                        .termsOfService("http://swagger.io/terms/")
	                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));

	    }

}
