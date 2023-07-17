package com.cadastrafilme.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cadastrafilme.demo.domain.livro.DadosAlteracaoLivro;
import com.cadastrafilme.demo.domain.livro.DadosCadastroLivro;
import com.cadastrafilme.demo.domain.livro.Livro;
import com.cadastrafilme.demo.domain.livro.LivroRepository;


@Controller
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroRepository repository;
	
	
	@GetMapping("/formulario")
	public String carregaFormularioLivros(Long id, Model model) {
		if(id != null) {
			var livro = repository.getReferenceById(id);
			model.addAttribute("livro",livro);
		}
		
		return "livros/formulario";
	}
	
	@GetMapping
	public String carregaListaLivros(Model model) {
		model.addAttribute("lista", repository.findAll());
		return "livros/listagem";
	}
	
	@PostMapping
	@Transactional
	public String cadastraLivro(DadosCadastroLivro dados) {
		var  livro = new Livro(dados);
		repository.save(livro);
	
		return "redirect:/livros";
		
	}

	@PutMapping
	@Transactional
	public String alteraLivro(DadosAlteracaoLivro dados) {
		var livro = repository.getReferenceById(dados.id());
		livro.atualizaDados(dados);
		return "redirect:/livros";
		
	}
	
	@DeleteMapping
	@Transactional
	public String removeLivro(Long id) {
		repository.deleteById(id);
		return "redirect:/livros";
	}
		
}
 