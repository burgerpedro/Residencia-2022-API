package br.com.residencia.biblioteca.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.residencia.biblioteca.DTO.EditoraDTO;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "codigoEditora")
@Entity
@Table(name = "editora")
public class Editora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigoeditora")
	private Integer codigoEditora;

	@Column(name = "nome")
	private String nome;
	
	
	//@JsonManagedReference(value = "editora-back")
	//@JsonIgnore
	@OneToMany(mappedBy = "editora")
	private Set<Livro> livros;
	
	
	public Editora() {
		// TODO Auto-generated constructor stub
	}

	/*
	public Editora(EditoraDTO editoraDTO) {
		this.codigoEditora = editoraDTO.getCodigoEditora();
		this.nome = editoraDTO.getNome();
	}
		*/
	public Integer getCodigoEditora() {
		return codigoEditora;
	}

	public void setCodigoEditora(Integer codigoEditora) {
		this.codigoEditora = codigoEditora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Livro> getLivros() {
		return livros;
	}

	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}

	
}
