package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

// @Configuration: Identifica que tratase de uma classe de configuração


/*A interface CommandLineRunner --> Tudo que estiver dentro deste metodo será executado
* Tudo que estiver dentro deste metodo será executado quando a aplicação for iniciada
*/ 


@Configuration
@Profile("test") // Deve ser igual ao nome inserido no arquivo application.properties (Profile)
public class TestConfig implements CommandLineRunner{

	// @Autowired: Associa a dependência
	// neste caso com o UserRepository que é responsável por fazer as operações de
	// banco
	// referente ao usuário

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}

}