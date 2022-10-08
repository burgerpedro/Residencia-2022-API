package br.com.residencia.biblioteca.entity;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "emprestimo")
public class Emprestimo {
	
	@Id
	@Column(name = "codigoemprestimo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoEmprestimo;
	
	//@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "numeromatriculaaluno",referencedColumnName = "numeromatriculaaluno")
	private Aluno aluno;
	
	//@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "codigolivro",referencedColumnName = "codigolivro")
	private Livro livro;
	
	@Column(name = "dataemprestimo")
	private Instant dataEmprestimo;
	
	@Column(name = "dataentrega")
	private Instant dataEntrega;
	
	@Column(name = "valoremprestimo")
	private BigDecimal valorEmprestimo;

	public Integer getCodigoEmprestimo() {
		return codigoEmprestimo;
	}

	public void setCodigoEmprestimo(Integer codigoEmprestimo) {
		this.codigoEmprestimo = codigoEmprestimo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
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
	
	
}	
