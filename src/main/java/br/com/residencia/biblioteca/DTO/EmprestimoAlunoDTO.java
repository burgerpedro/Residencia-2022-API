package br.com.residencia.biblioteca.DTO;

import java.time.Instant;


public class EmprestimoAlunoDTO {

	private Integer codigoEmprestimo;

	private Instant dataEmprestimo;

	private Instant dataEntrega;

	public EmprestimoAlunoDTO() {
		// TODO Auto-generated constructor stub
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

	
	
}
