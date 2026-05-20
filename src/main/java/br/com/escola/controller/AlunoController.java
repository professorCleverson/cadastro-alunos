/*
 * Essa classe é um Controller MVC do Spring Boot.
 * Ela recebe requisições HTTP, conversa com o banco através do 
 * AlunoRepository e retorna páginas HTML.
 * No padrão MVC:
 * Model → dados (Aluno)
 * View → páginas HTML (lista.html, formulario.html)
 * Controller → controla as requisições
 * O controller funciona como um “intermediário” entre navegador, 
 * banco e páginas.
 */
package br.com.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.escola.model.Aluno;
import br.com.escola.repository.AlunoRepository;

@Controller // Diz ao Spring: “Essa classe controla requisições web.”
			// O Spring registra automaticamente essa classe para responder URLs.
public class AlunoController {

	@Autowired // Faz injeção automática de dependência.
				// O Spring cria o objeto AlunoRepository e coloca aqui automaticamente
	private AlunoRepository repository;

	@GetMapping("/") // Mapeia requisições GET para a URL: http://localhost:8080/
	public String inicio() {
		return "redirect:/alunos"; // Redireciona o navegador para: /alunos
	}

	@GetMapping("/alunos") // Mapeia requisições GET para quando alguém acessa: /alunos
	public String listar(Model model) {

		List<Aluno> lista = repository.findAll(); // Usa o JpaRepository para buscar todos os registros do banco.

		model.addAttribute("alunos", lista); // Coloca a lista dentro do objeto Model e Envia dados para a View.

		return "lista"; // Retorna a página templates/lista.html
	}

	@GetMapping("/novo") // Abre o formulário para cadastrar aluno.
	public String novo(Model model) {

		model.addAttribute("aluno", new Aluno()); // Envia um objeto vazio para o formulário HTML.

		return "formulario"; // Retorna página formulário templates/formulario.html
	}

	@PostMapping("/salvar")
	public String salvar(@ModelAttribute Aluno aluno) { // Recebe os dados enviados pelo formulário.

		repository.save(aluno); // Salva no banco. O JPA salva o aluno no banco.

		return "redirect:/alunos"; // Após salvar:
									// volta para a listagem;
									// evita duplicação ao atualizar a página.
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		repository.deleteById(id);
		return "redirect:/aluno";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {

		Aluno aluno = repository.findById(id).orElse(null);

		model.addAttribute("aluno", aluno);

		return "formulario";
	}

}
