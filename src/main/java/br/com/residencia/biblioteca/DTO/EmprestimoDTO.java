package br.com.residencia.biblioteca.DTO;

import java.math.BigDecimal;
import java.time.Instant;

import br.com.residencia.biblioteca.entity.Aluno;



public class EmprestimoDTO {
	
private Integer codigoEmprestimo;
	
	private Instant dataEmprestimo;
	
	private Instant dataEntrega;
	
	private BigDecimal valorEmprestimo;
	
	private AlunoDTO alunoDTO;
	
	private LivroDTO livroDTO;


	public EmprestimoDTO() {
		// TODO Auto-generated constructor stub
	}


	public EmprestimoDTO(Integer codigoEmprestimo, Instant dataEmprestimo, Instant dataEntrega,
			BigDecimal valorEmprestimo) {
		this.codigoEmprestimo = codigoEmprestimo;
		this.dataEmprestimo = dataEmprestimo;
		this.dataEntrega = dataEntrega;
		this.valorEmprestimo = valorEmprestimo;
	}


	public Integer getCodigoEmprestimo() {
		return codigoEmprestimo;
	}


	public void setCodigoEmprestimo(Integer codigoEmprestimo) {
		this.codigoEmprestimo = codigoEmprestimo;
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


	public BigDecimal getValorEmprestimo() {
		return valorEmprestimo;
	}


	public void setValorEmprestimo(BigDecimal valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}


	public AlunoDTO getAlunoDTO() {
		return alunoDTO;
	}


	public void setAlunoDTO(AlunoDTO alunoDTO) {
		this.alunoDTO = alunoDTO;
	}


	public LivroDTO getLivroDTO() {
		return livroDTO;
	}


	public void setLivroDTO(LivroDTO livroDTO) {
		this.livroDTO = livroDTO;
	}

	
}
