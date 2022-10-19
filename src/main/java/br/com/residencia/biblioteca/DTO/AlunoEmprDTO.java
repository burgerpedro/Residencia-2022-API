package br.com.residencia.biblioteca.DTO;

import java.time.Instant;
import java.util.List;

public class AlunoEmprDTO {
	
	private Integer numeroMatriculaAluno;
	
	private String nome;
	
	private String cpf;
	
	private List<EmprestimoAlunoDTO> emprestimoAlunoDTO;
	


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



	public List<EmprestimoAlunoDTO> getEmprestimoAlunoDTO() {
		return emprestimoAlunoDTO;
	}



	public void setEmprestimoAlunoDTO(List<EmprestimoAlunoDTO> emprestimoAlunoDTO) {
		this.emprestimoAlunoDTO = emprestimoAlunoDTO;
	}


}
