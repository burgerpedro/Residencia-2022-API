package br.com.residencia.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.DTO.AlunoDTO;
import br.com.residencia.biblioteca.DTO.EmprestimoAlunoDTO;
import br.com.residencia.biblioteca.DTO.EmprestimoDTO;
import br.com.residencia.biblioteca.DTO.LivroDTO;
import br.com.residencia.biblioteca.entity.Aluno;
import br.com.residencia.biblioteca.entity.Emprestimo;
import br.com.residencia.biblioteca.entity.Livro;
import br.com.residencia.biblioteca.repository.AlunoRepository;
import br.com.residencia.biblioteca.repository.EmprestimoRespository;
import br.com.residencia.biblioteca.repository.LivroRepository;

@Service
public class EmprestimoService {
	
	@Autowired
	EmprestimoRespository emprestimoRepository;
	
	public List<Emprestimo> getAllEmprestimos() {
		return emprestimoRepository.findAll();
		
	}
	
	public List<EmprestimoDTO> gettAllEmprestimosDTO(){
		List<Emprestimo> emprestimos = emprestimoRepository.findAll();
		List<EmprestimoDTO> emprestimosDTO = new ArrayList<>();
		
		for(Emprestimo emprestimo : emprestimos) {
				
		EmprestimoDTO emprestimoDTO =	toDTO(emprestimo);
			
			emprestimosDTO.add(emprestimoDTO);
		}
		
		return emprestimosDTO;
	}
	
	
	public List<EmprestimoDTO> gettAllLivrosAlunosEmprestimosDTO(){
		List<Emprestimo> emprestimos = emprestimoRepository.findAll();
		List<EmprestimoDTO> emprestimosDTO = new ArrayList<>();
		
		for(Emprestimo emprestimo : emprestimos) {
			LivroDTO livroDTO = new LivroDTO();
			AlunoDTO alunoDTO = new AlunoDTO();
			
		EmprestimoDTO emprestimoDTO =	toDTO(emprestimo);

		emprestimosDTO.add(emprestimoDTO);
			
		}
		
		return emprestimosDTO;
	}
	
	
	public Emprestimo getEmprestimoById(Integer id) {
		//return emprestimoRepository.findById(id).get();
		return emprestimoRepository.findById(id).orElse(null);
	}
	
	public Emprestimo saveEmprestimo(Emprestimo emprestimo) {
		return emprestimoRepository.save(emprestimo);
	}
	
	public EmprestimoDTO saveEmprestimoDTO(EmprestimoDTO emprestimoDTO) {
		Emprestimo emprestimo = toEntidade(emprestimoDTO);
		Emprestimo novaEmprestimo = emprestimoRepository.save(emprestimo);
		
		EmprestimoDTO emprestimoAtualizadaDTO = toDTO(novaEmprestimo);
		
			return emprestimoAtualizadaDTO;
	}		
	
	public Emprestimo updateEmprestimo(Emprestimo emprestimo,Integer id) {
		
		Emprestimo emprestimoExiteNoBanco = getEmprestimoById(id);
		
		
		emprestimoExiteNoBanco.setDataEmprestimo(emprestimo.getDataEmprestimo());
		emprestimoExiteNoBanco.setDataEntrega(emprestimo.getDataEntrega());
		emprestimoExiteNoBanco.setValorEmprestimo(emprestimo.getValorEmprestimo());
		
		return emprestimoRepository.save(emprestimo);
		
	}
	
	public EmprestimoDTO updateEmprestimoDTO(EmprestimoDTO emprestimoDTO,Integer id) {
		Emprestimo emprestimoExisteNoBanco = getEmprestimoById(id);
		EmprestimoDTO emprestimoAtualizadaDTO = new EmprestimoDTO();
		
		if(emprestimoExisteNoBanco != null) {
			
			emprestimoExisteNoBanco = toEntidade(emprestimoDTO);
			
			Emprestimo emprestimoAtualizada = emprestimoRepository.save(emprestimoExisteNoBanco);
			
			emprestimoAtualizadaDTO = toDTO(emprestimoAtualizada);
			
		}
		return emprestimoAtualizadaDTO;
	
	}
		
	public Emprestimo deleteEmprestimo(Integer id) {
		emprestimoRepository.deleteById(id);
		return getEmprestimoById(id);
	}	
	
	public Emprestimo toEntidade(EmprestimoDTO emprestimoDTO){
		Emprestimo emprestimo = new Emprestimo();
		
		emprestimo.setDataEmprestimo(emprestimoDTO.getDataEmprestimo());
		emprestimo.setDataEntrega(emprestimoDTO.getDataEntrega());
		emprestimo.setValorEmprestimo(emprestimoDTO.getValorEmprestimo());
		
		return emprestimo;
		}
	
	public EmprestimoDTO toDTO(Emprestimo emprestimo) {
		EmprestimoDTO emprestimoDTO = new EmprestimoDTO();
		
		emprestimoDTO.setCodigoEmprestimo(emprestimo.getCodigoEmprestimo());
		emprestimoDTO.setDataEmprestimo(emprestimo.getDataEmprestimo());
		emprestimoDTO.setDataEntrega(emprestimo.getDataEntrega());
		emprestimoDTO.setValorEmprestimo(emprestimo.getValorEmprestimo());
		
		return emprestimoDTO;
		
	}
	
	public EmprestimoAlunoDTO toDTO2(Emprestimo emprestimo) {
		EmprestimoAlunoDTO emprestimoAlunoDTO = new EmprestimoAlunoDTO();
		
		emprestimoAlunoDTO.setCodigoEmprestimo(emprestimo.getCodigoEmprestimo());
		emprestimoAlunoDTO.setDataEmprestimo(emprestimo.getDataEmprestimo());
		emprestimoAlunoDTO.setDataEntrega(emprestimo.getDataEntrega());
		
		return emprestimoAlunoDTO;
		
	}
	
}
