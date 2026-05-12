package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity // cria uma entidade chamada Aluno no BD.
public class Aluno {
	
	@jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nome;
	private String email; 
	private String curso;
	
	public Aluno() {
		
	}

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
