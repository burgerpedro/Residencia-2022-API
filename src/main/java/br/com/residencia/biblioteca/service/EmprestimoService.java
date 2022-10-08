package br.com.residencia.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.entity.Emprestimo;
import br.com.residencia.biblioteca.repository.EmprestimoRespository;

@Service
public class EmprestimoService {
	
	@Autowired
	EmprestimoRespository emprestimoRepository;
	
	
	public List<Emprestimo> getAllEmprestimos() {
		return emprestimoRepository.findAll();
		
	}
	
	public Emprestimo getEmprestimoById(Integer id) {
		//return emprestimoRepository.findById(id).get();
		return emprestimoRepository.findById(id).orElse(null);
	}
	
	public Emprestimo saveEmprestimo(Emprestimo emprestimo) {
		return emprestimoRepository.save(emprestimo);
	}
	
	public Emprestimo updateEmprestimo(Emprestimo emprestimo,Integer id) {
		
		Emprestimo emprestimoExiteNoBanco = getEmprestimoById(id);
		
		
		emprestimoExiteNoBanco.setDataEmprestimo(emprestimo.getDataEmprestimo());
		emprestimoExiteNoBanco.setDataEntrega(emprestimo.getDataEntrega());
		emprestimoExiteNoBanco.setValorEmprestimo(emprestimo.getValorEmprestimo());
		
		return emprestimoRepository.save(emprestimo);
		
	}
	
	public Emprestimo deleteEmprestimo(Integer id) {
		emprestimoRepository.deleteById(id);
		return getEmprestimoById(id);
	}	
}
