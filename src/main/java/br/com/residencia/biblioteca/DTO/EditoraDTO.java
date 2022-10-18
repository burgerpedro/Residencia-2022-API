package br.com.residencia.biblioteca.DTO;

import java.util.List;
import java.util.Set;

import br.com.residencia.biblioteca.entity.Editora;

public class EditoraDTO {

	private Integer codigoEditora;
	private String nome;
	private List<LivroDTO> livrosDTO;

	
	public EditoraDTO() {
	}

	public EditoraDTO(Editora editora) {
		this.codigoEditora = editora.getCodigoEditora();
		this.nome = editora.getNome();
	}
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getCodigoEditora() {
		return codigoEditora;
	}


	public void setCodigoEditora(Integer codigoEditora) {
		this.codigoEditora = codigoEditora;
	}



	public List<LivroDTO> getLivrosDTO() {
		return livrosDTO;
	}



	public void setLivrosDTO(List<LivroDTO> livrosDTO) {
		this.livrosDTO = livrosDTO;
	}


}
