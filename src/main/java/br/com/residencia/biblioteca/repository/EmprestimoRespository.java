package br.com.residencia.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.biblioteca.entity.Aluno;
import br.com.residencia.biblioteca.entity.Emprestimo;
import br.com.residencia.biblioteca.entity.Livro;

public interface EmprestimoRespository extends JpaRepository<Emprestimo, Integer>{

}
