/*
 * Essa classe representa a entidade Aluno da aplicação.
 * Ela é o objeto Java que será transformado em uma tabela no banco de dados pelo JPA/Hibernate.
 */
package br.com.escola.model;

import jakarta.persistence.*;

@Entity // Essa anotação diz ao JPA: “Essa classe deve virar uma tabela no banco de dados.”
public class Aluno {

	@Id //Indica que esse atributo é a chave primária da tabela.
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Faz o banco gerar o ID automaticamente usando o auto incremento do banco.
	private Long Id;
	private String nome;
	private String email;
	private String curso;

	public Aluno() { //O JPA exige um construtor vazio. O Hibernate usa ele para criar objetos automaticamente quando lê dados do banco.

	}
	
	/*
	 * Getters e Setters: Servem para acessar e modificar os atributos.
	 * Por que usar getters/setters? Porque normalmente os atributos ficam privados:
	 * Então o acesso é feito por métodos:
	 */

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

}
