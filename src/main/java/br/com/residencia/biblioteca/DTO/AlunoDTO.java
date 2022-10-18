package br.com.residencia.biblioteca.DTO;

import java.time.Instant;
import java.util.List;


public class AlunoDTO {

	private Integer numeroMatriculaAluno;
	
	private String nome;
	
	private Instant dataNascimento; 
	
	private String cpf;
	
	private String logradouro;
	
	private String numeroLogradouro;
	
	private String complemento; 

	private String bairro;
	
	private String cidade;
	
	private List<EmprestimoDTO> emprestimosDTO;
	
	private Integer idEmprestimo;
	
	private Instant dataEmprestimo;
	
	private Instant dataEntrega;
	
	public AlunoDTO() {
		// TODO Auto-generated constructor stub
	}

	public AlunoDTO(Integer numeroMatriculaAluno, String nome, Instant dataNascimento, String cpf, String logradouro,
			String numeroLogradouro, String complemento, String bairro, String cidade) {
		this.numeroMatriculaAluno = numeroMatriculaAluno;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.logradouro = logradouro;
		this.numeroLogradouro = numeroLogradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
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

	public Instant getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Instant dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumeroLogradouro() {
		return numeroLogradouro;
	}

	public void setNumeroLogradouro(String numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<EmprestimoDTO> getEmprestimosDTO() {
		return emprestimosDTO;
	}

	public void setEmprestimosDTO(List<EmprestimoDTO> emprestimosDTO) {
		this.emprestimosDTO = emprestimosDTO;
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
