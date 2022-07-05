package com.exemploSecurityJPA;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
//implementa um cadastro de produtos, onde somente admins conseguem editar ou alterar, vide index.html. Nao possui interface para cadastro de usuários
@SpringBootApplication
public class ProductManagerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagerApplication.class, args);
	}
	
	@Bean//Bean para adicionar dados as tabela User ao rodar a aplicação
	public CommandLineRunner mappingDemo( UserRepository userRepository) {
		return args -> {

			// cria novos usuuários
			User u1 = new User();
			User u2 = new User();
			u1.setEnabled(true);
			u1.setPassword("$2a$10$zxvEq8XzYEYtNjbkRsJEbukHeRx3XS6MDXHMu8cNuNsRfZJWwswDy");//(User: Admin Pass: nimda)
			u1.setRole("ROLE_ADMIN");
			u1.setUsername("Admin");
			
			u2.setEnabled(true);
			u2.setPassword("$2a$10$zxvEq8XzYEYtNjbkRsJEbukHeRx3XS6MDXHMu8cNuNsRfZJWwswDy");//(User:User Pass: nimda)
			u2.setRole("ROLE_USER");
			u2.setUsername("User");
			
			userRepository.save(u1); // Salva usuários no banco
			userRepository.save(u2);
		};
	}

}
