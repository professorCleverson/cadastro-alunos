/*
 * Essa é a classe principal da aplicação Spring Boot.
 * Ela é responsável por iniciar toda a aplicação.
 * 
 * Quando você executa essa classe o Spring Boot:
 * inicia o servidor (Tomcat embutido);
 * carrega as configurações;
 * encontra componentes (@Controller, @Service, @Repository);
 * conecta ao banco;
 * configura o JPA/Hibernate;
 * sobe a aplicação web.
 */
package br.com.escola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CadastroAlunosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroAlunosApplication.class, args);
	}

}
