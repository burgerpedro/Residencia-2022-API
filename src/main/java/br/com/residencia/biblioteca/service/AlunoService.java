package br.com.residencia.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.DTO.AlunoDTO;
import br.com.residencia.biblioteca.DTO.AlunoEmprDTO;
import br.com.residencia.biblioteca.DTO.EmprestimoDTO;
import br.com.residencia.biblioteca.entity.Aluno;
import br.com.residencia.biblioteca.entity.Emprestimo;
import br.com.residencia.biblioteca.repository.AlunoRepository;
import br.com.residencia.biblioteca.repository.EmprestimoRespository;

@Service
public class AlunoService {
	
		@Autowired
		AlunoRepository alunoRepository;
		
		@Autowired
		EmprestimoService emprestimoService;
		
		@Autowired
		EmprestimoRespository emprestimoRespository;
	
	public List<Aluno> getAllAlunos(){
		return alunoRepository.findAll();
		
	}
		
		public List<AlunoDTO> getAllAlunosDTO(){
		List<Aluno> alunos = alunoRepository.findAll();
		List<AlunoDTO> alunosDTO = new ArrayList<>();
		
		for(Aluno aluno: alunos) {
			
			
			AlunoDTO alunoDTO= toDTO(aluno);
			alunosDTO.add(alunoDTO);
		}
		return alunosDTO;
	}
		
		public List<AlunoEmprDTO> getAllAlunobyEmprestimosDTO(){
			List<Aluno> alunos = alunoRepository.findAll();
			List<AlunoEmprDTO> alunosEmprDTO = new ArrayList<>();
			
			
			for(Aluno aluno: alunos) {
				AlunoEmprDTO alunoEmprDTO = new AlunoEmprDTO();
				
				alunoEmprDTO.setNumeroMatriculaAluno(aluno.getNumeroMatriculaAluno());
				alunoEmprDTO.setNome(aluno.getNome());
				alunoEmprDTO.setCpf(aluno.getCpf());
				
				
				
				
				
				
				
				alunosEmprDTO.add(alunoEmprDTO);
			}
			return alunosEmprDTO;
		}
		

		public List<AlunoDTO> getAllAlunobyEmprestimosDTO2(){
			List<Aluno> alunos = alunoRepository.findAll();
			List<AlunoDTO> alunosDTO = new ArrayList<>();
			
			
			for(Aluno aluno: alunos) {
				AlunoDTO alunoDTO = toDTO(aluno);
				List<EmprestimoDTO> listaEmprestimosDTO = new ArrayList<>();
				
				alunoDTO.setEmprestimosDTO(listaEmprestimosDTO);
				
				alunosDTO.add(alunoDTO);
			}
			return alunosDTO;
		}
		
		
	
	public Aluno getAlunoById(Integer id) {
		//return alunoRepository.findById(id).get();
		return alunoRepository.findById(id).orElse(null);
		
	}
	
	public Aluno saveAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
		
	}
	
	public AlunoDTO saveAlunoDTO(AlunoDTO alunoDTO) {
		Aluno aluno = toEntidade(alunoDTO);
		Aluno novoAluno = alunoRepository.save(aluno);
		
		AlunoDTO alunoAtualizadaDTO = toDTO(novoAluno);
		
			return alunoAtualizadaDTO;
	}	
	
	
	public Aluno updateAluno(Aluno aluno,Integer id) {
	
		//Aluno alunoExistenteNoBanco	= alunoRepository.findById(id).get();
		Aluno alunoExistenteNoBanco = getAlunoById(id);
		
		alunoExistenteNoBanco.setBairro(aluno.getBairro());
		alunoExistenteNoBanco.setCidade(aluno.getCidade());
		alunoExistenteNoBanco.setComplemento(aluno.getComplemento());
		alunoExistenteNoBanco.setCpf(aluno.getCpf());
		alunoExistenteNoBanco.setDataNascimento(aluno.getDataNascimento());
		alunoExistenteNoBanco.setLogradouro(aluno.getLogradouro());
		alunoExistenteNoBanco.setNome(aluno.getNome());
		alunoExistenteNoBanco.setNumeroLogradouro(aluno.getNumeroLogradouro());
		alunoExistenteNoBanco.setNumeroMatriculaAluno(aluno.getNumeroMatriculaAluno());
			return alunoRepository.save(alunoExistenteNoBanco);
	}
	
	public AlunoDTO updateAlunoDTO(AlunoDTO alunoDTO,Integer id) {
		Aluno alunoExisteNoBanco = getAlunoById(id);
		AlunoDTO alunoAtualizadaDTO = new AlunoDTO();
		
		if(alunoExisteNoBanco != null) {
			
			alunoExisteNoBanco = toEntidade(alunoDTO);
			
		//	alunoExisteNoBanco.setNome(alunoDTO.getNome());
			Aluno alunoAtualizada = alunoRepository.save(alunoExisteNoBanco);
			
			alunoAtualizadaDTO = toDTO(alunoAtualizada);
			
			//alunoAtualizadaDTO.setCodigoAluno(alunoAtualizada.getCodigoAluno());
			//alunoAtualizadaDTO.setNome(alunoAtualizada.getNome());
		}
		return alunoAtualizadaDTO;
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
	
	
	public AlunoDTO toDTO(Aluno aluno) {
		AlunoDTO alunoDTO = new AlunoDTO();
		
		alunoDTO.setNumeroMatriculaAluno(aluno.getNumeroMatriculaAluno());
		alunoDTO.setNome(aluno.getNome());
		alunoDTO.setLogradouro(aluno.getLogradouro());
		alunoDTO.setCpf(aluno.getCpf());
		alunoDTO.setNumeroLogradouro(aluno.getNumeroLogradouro());
		alunoDTO.setCidade(aluno.getCidade());
		alunoDTO.setBairro(aluno.getBairro());
		alunoDTO.setComplemento(aluno.getComplemento());
		alunoDTO.setDataNascimento(aluno.getDataNascimento());
		
		return alunoDTO;
	
	}
	
	public Aluno toEntidade(AlunoDTO alunoDTO) {
		Aluno aluno = new Aluno();
		
	aluno.setNome(alunoDTO.getNome());
	aluno.setLogradouro(alunoDTO.getLogradouro());
	aluno.setCpf(alunoDTO.getCpf());
	aluno.setNumeroLogradouro(alunoDTO.getNumeroLogradouro());
	aluno.setCidade(alunoDTO.getCidade());
	aluno.setBairro(alunoDTO.getBairro());
	aluno.setComplemento(alunoDTO.getComplemento());
	aluno.setDataNascimento(alunoDTO.getDataNascimento());
	
	return aluno;
	}
	
	
}
	