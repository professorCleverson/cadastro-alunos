/*
 * Essa classe (na verdade, uma interface) define um repositório
 * do Spring Data JPA para a entidade Aluno.
 * 
 * Ao estender JpaRepository<Aluno, Long>, o Spring cria automaticamente 
 * uma implementação com operações prontas de banco de dados para a 
 * entidade Aluno.
 */

package br.com.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escola.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
