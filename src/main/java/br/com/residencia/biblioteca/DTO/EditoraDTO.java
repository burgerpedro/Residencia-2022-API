package br.com.residencia.biblioteca.DTO;

import br.com.residencia.biblioteca.entity.Editora;

public class EditoraDTO {

	private Integer codigoEditora;
	private String nome;

	
	public EditoraDTO() {
		// TODO Auto-generated constructor stub
	}


	public EditoraDTO(Integer codigoEditora, String nome) {
		this.codigoEditora = codigoEditora;
		this.nome = nome;
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

}
