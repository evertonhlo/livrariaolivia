package com.cadastrafilme.demo.domain.livro;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "livros")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String autor;
	private String editora;
	private String categoria;
	
	public Livro(DadosCadastroLivro dados){
		this.titulo = dados.titulo();
		this.autor = dados.autor();
		this.editora = dados.editora();
		this.categoria = dados.categoria();
		
	}
	
	public Livro() {};
	
	public String getTitulo() {
		return titulo;
	}
	@Override
	public String toString() {
		return "Filme [titulo=" + titulo + ", autor=" + autor + ", editora=" + editora + ", categoria=" + categoria
				+ "]";
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void atualizaDados(DadosAlteracaoLivro dados) {
		// TODO Auto-generated method stub
		this.titulo = dados.titulo();
		this.autor = dados.autor();
		this.editora = dados.editora();
		this.categoria = dados.categoria();
		
	}
	
	

}
