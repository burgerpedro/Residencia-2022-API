package br.com.residencia.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.entity.Aluno;
import br.com.residencia.biblioteca.repository.AlunoRepository;

@Service
public class AlunoService {
	
		@Autowired
		AlunoRepository alunoRepository;
	
	public List<Aluno> getAllAlunos(){
		return alunoRepository.findAll();

	}
	
	public Aluno getAlunoById(Integer id) {
		return alunoRepository.findById(id).get();
		//return alunoRepository.findById(id).orElse(null);
		
	}
	
	public Aluno saveAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
		
	}
	
	public Aluno updateAluno(Aluno aluno,Integer id) {
	
		//Aluno alunoExistenteNoBanco	= alunoRepository.findById(id).get();
		Aluno 
		alunoExistenteNoBanco = getAlunoById(id);
		
		alunoExistenteNoBanco.setBairro(aluno.getBairro());
		alunoExistenteNoBanco.setCidade(aluno.getCidade());
		alunoExistenteNoBanco.setComplemento(aluno.getComplemento());
		alunoExistenteNoBanco.setCpf(aluno.getCpf());
		alunoExistenteNoBanco.setDataNascimento(aluno.getDataNascimento());
		alunoExistenteNoBanco.setEmprestimo(aluno.getEmprestimo());
		alunoExistenteNoBanco.setLogradouro(aluno.getLogradouro());
		alunoExistenteNoBanco.setNome(aluno.getNome());
		alunoExistenteNoBanco.setNumeroLogradouro(aluno.getNumeroLogradouro());
		alunoExistenteNoBanco.setNumeroMatriculaAluno(aluno.getNumeroMatriculaAluno());
			return alunoRepository.save(alunoExistenteNoBanco);
	}
	
	public Aluno deleteAluno(Integer id) {
		alunoRepository.deleteById(id);
		return getAlunoById(id);
		/*if(null != getAlunoById(id))
			return false;
		else
			return true;
		*/
	}
	
	
}
	