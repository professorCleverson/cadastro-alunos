package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import model.Aluno;
import repository.AlunoRepository;

@Controller //Torna esta classe como uma classe Controller
public class AlunoController {
	
	@Autowired // Injeta dependências de forma automática
    private AlunoRepository repository;
	
	@GetMapping("/") //Mapeia requisições do tipo HTTP
    public String inicio() {
        return "redirect:/alunos";
    }
	
	@GetMapping("/alunos")
    public String listar(Model model) {

        List<Aluno> lista = repository.findAll();

        model.addAttribute("alunos", lista);

        return "lista";
    }
	
	 @GetMapping("/novo")
	    public String novo(Model model) {

	        model.addAttribute("aluno", new Aluno());

	        return "formulario";
	    }
	
	

}
