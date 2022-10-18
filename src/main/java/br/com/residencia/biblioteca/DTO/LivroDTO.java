package br.com.residencia.biblioteca.DTO;

import java.time.Instant;
import java.util.List;

public class LivroDTO {

	private Integer codigoLivro;
	
	private String nomeLivro;
	
	private String nomeAutor;
	
	private Instant dataLancamento;
	
	private Integer codigoIsbn;
	
	private List<EmprestimoDTO> emprestimosDTO;
	
	public LivroDTO() {
	}


	public LivroDTO(Integer codigoLivro, String nomeLivro, String nomeAutor, Instant dataLancamento,
			Integer codigoIsbn) {
		this.codigoLivro = codigoLivro;
		this.nomeLivro = nomeLivro;
		this.nomeAutor = nomeAutor;
		this.dataLancamento = dataLancamento;
		this.codigoIsbn = codigoIsbn;
	}


	public Integer getCodigoLivro() {
		return codigoLivro;
	}

	public void setCodigoLivro(Integer codigoLivro) {
		this.codigoLivro = codigoLivro;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public Instant getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Instant dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Integer getCodigoIsbn() {
		return codigoIsbn;
	}

	public void setCodigoIsbn(Integer codigoIsbn) {
		this.codigoIsbn = codigoIsbn;
	}


	public List<EmprestimoDTO> getEmprestimosDTO() {
		return emprestimosDTO;
	}


	public void setEmprestimosDTO(List<EmprestimoDTO> emprestimosDTO) {
		this.emprestimosDTO = emprestimosDTO;
	}


	
	

}
