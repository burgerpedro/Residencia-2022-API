package br.com.residencia.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.biblioteca.entity.Aluno;
import br.com.residencia.biblioteca.entity.Emprestimo;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

	
	
}
