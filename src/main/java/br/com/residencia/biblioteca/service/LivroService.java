package br.com.residencia.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.DTO.EmprestimoDTO;
import br.com.residencia.biblioteca.DTO.LivroDTO;
import br.com.residencia.biblioteca.entity.Emprestimo;
import br.com.residencia.biblioteca.entity.Livro;
import br.com.residencia.biblioteca.repository.EmprestimoRespository;
import br.com.residencia.biblioteca.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;
	
	
	public List<Livro> getAllLivros() {
		return livroRepository.findAll();
		
	}
	
	public List<LivroDTO> getAllLivrosDTO(){
		List<Livro> livros = livroRepository.findAll();
		List<LivroDTO> livrosDTO = new ArrayList<>();
		
		for(Livro livro : livros) {
			LivroDTO livroDTO = toDTO(livro);
			
			
			livrosDTO.add(livroDTO);
		}
		return livrosDTO;
	}
	
	public List<LivroDTO> getAllLivrosbyEmprestimoDTO(){
		List<Livro> livros = livroRepository.findAll();
		List<LivroDTO> livrosDTO = new ArrayList<>();
		
		for(Livro livro : livros) {
			LivroDTO livroDTO = toDTO(livro);
			List<Emprestimo> listaEmprestimos = new ArrayList<>();
			List<EmprestimoDTO> listaEmprestimosDTO = new ArrayList<>();
			
			livroDTO.setEmprestimosDTO(listaEmprestimosDTO);
			
			livrosDTO.add(livroDTO);
		}
		return livrosDTO;
	}
	
	
	public Livro getLivroById(Integer id) {
		return livroRepository.findById(id).get();
		//return livroRepository.findById(id).orElse(null);
	}
	
	public Livro saveLivro(Livro livro) {
		return livroRepository.save(livro);
		
	}	
	
	public LivroDTO saveLivroDTO(LivroDTO livroDTO) {
			Livro livro = toEntidade(livroDTO);
			Livro novoLivro = livroRepository.save(livro);
		
			LivroDTO livroDTOAtualizado = toDTO(novoLivro);
		
		return livroDTOAtualizado;
	}

	public Livro updateLivro(Livro livro,Integer id) {
		
		Livro livroExisteNoBanco = getLivroById(id);
		
		livroExisteNoBanco.setCodigoIsbn(livro.getCodigoIsbn());
		livroExisteNoBanco.setDataLancamento(livro.getDataLancamento());
		livroExisteNoBanco.setNomeAutor(livro.getNomeAutor());
		livroExisteNoBanco.setNomeLivro(livro.getNomeLivro());
		
		return livroRepository.save(livroExisteNoBanco);
		
	}
	
	
public LivroDTO updateLivroDTO(LivroDTO livroDTO,Integer id) {
		Livro livroExisteNoBanco = getLivroById(id);
		LivroDTO livroDTOAtualizado = new LivroDTO();
		
		if(livroExisteNoBanco != null){
		
			livroExisteNoBanco = toEntidade(livroDTO);
			
			Livro livroAtualizado = livroRepository.save(livroExisteNoBanco);
			
			livroDTOAtualizado = toDTO(livroAtualizado);
		}
		return livroDTOAtualizado;
	}
	
	public Livro deleteLivro(Integer id) {
		livroRepository.deleteById(id);
		return getLivroById(id);
		
	}
	
	public LivroDTO toDTO(Livro livro) {
		LivroDTO livroDTO = new LivroDTO();
		
		livroDTO.setCodigoLivro(livro.getCodigoLivro());
		livroDTO.setNomeLivro(livro.getNomeLivro());
		livroDTO.setNomeAutor(livro.getNomeAutor());
		livroDTO.setDataLancamento(livro.getDataLancamento());
		livroDTO.setCodigoIsbn(livro.getCodigoIsbn());
		
		return livroDTO;
	}
	
	public Livro toEntidade(LivroDTO livroDTO) {
		Livro livro = new Livro();
		
		livro.setNomeLivro(livroDTO.getNomeLivro());
		livro.setNomeAutor(livroDTO.getNomeAutor());
		livro.setDataLancamento(livro.getDataLancamento());
		livro.setCodigoIsbn(livroDTO.getCodigoIsbn());
		
		return livro;
	}
}	