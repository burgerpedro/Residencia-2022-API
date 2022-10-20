package br.com.residencia.biblioteca.DTO;

import java.util.List;
import java.util.Set;

import br.com.residencia.biblioteca.entity.Editora;

public class EditoraDTO {

	private Integer codigoEditora;
	private String nome;
	private List<LivroDTO> livrosDTO;
	private String imagemNome;
	private String imagemFileName;
	private String imagemUrl;

	
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
	

	public String getImagemNome() {
		return imagemNome;
	}

	public void setImagemNome(String imagemNome) {
		this.imagemNome = imagemNome;
	}

	public String getImagemFileName() {
		return imagemFileName;
	}

	public void setImagemFileName(String imagemFileName) {
		this.imagemFileName = imagemFileName;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

	@Override
	public String toString() {
		return "EditoraDTO [codigoEditora=" + codigoEditora + ", nome=" + nome + ", livrosDTO=" + livrosDTO + "]";
	}


	
}
