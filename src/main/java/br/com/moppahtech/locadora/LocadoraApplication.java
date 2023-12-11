package br.com.moppahtech.locadora;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Documentação API Locadora UNIVESP",
				version = "1.0",
				description = " API de Gerenciamento da Locadora UNIVESP"
		)
)
public class LocadoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocadoraApplication.class, args);
	}

}
