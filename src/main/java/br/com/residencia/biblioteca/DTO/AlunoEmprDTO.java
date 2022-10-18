package br.com.residencia.biblioteca.DTO;

import java.time.Instant;

public class AlunoEmprDTO {
	
	private Integer numeroMatriculaAluno;
	
	private String nome;
	
	private String cpf;
	
	private Integer idEmprestimo;
	
	private Instant dataEmprestimo;
	
	private Instant dataEntrega;
	

	public AlunoEmprDTO() {
		// TODO Auto-generated constructor stub
	}


	public Integer getNumeroMatriculaAluno() {
		return numeroMatriculaAluno;
	}


	public void setNumeroMatriculaAluno(Integer numeroMatriculaAluno) {
		this.numeroMatriculaAluno = numeroMatriculaAluno;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Integer getIdEmprestimo() {
		return idEmprestimo;
	}


	public void setIdEmprestimo(Integer idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}


	public Instant getDataEmprestimo() {
		return dataEmprestimo;
	}


	public void setDataEmprestimo(Instant dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}


	public Instant getDataEntrega() {
		return dataEntrega;
	}


	public void setDataEntrega(Instant dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	
}
