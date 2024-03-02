package br.com.mrocha.desafio6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class DesafioBackend06Application {

	public static void main(String[] args) {
		SpringApplication.run(DesafioBackend06Application.class, args);
	}

}
