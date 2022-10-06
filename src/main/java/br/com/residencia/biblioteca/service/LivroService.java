package br.com.residencia.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.entity.Livro;
import br.com.residencia.biblioteca.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;
	
	public List<Livro> getAllLivros() {
		return livroRepository.findAll();
		
	}
	
	public Livro getLivroById(Integer id) {
		return livroRepository.findById(id).get();
		
	}
	
	public Livro saveLivro(Livro livro) {
		return livroRepository.save(livro);
		
	}
	
	public Livro updateLivro(Livro livro,Integer id) {
		
		Livro livroExisteNoBanco = getLivroById(id);
		
		livroExisteNoBanco.setCodigoIsbn(livro.getCodigoIsbn());
		livroExisteNoBanco.setDataLancamento(livro.getDataLancamento());
		livroExisteNoBanco.setNomeAutor(livro.getNomeAutor());
		livroExisteNoBanco.setNomeLivro(livro.getNomeLivro());
		
		return livroRepository.save(livroExisteNoBanco);
		
	}
	
	public Livro deleteLivro(Integer id) {
		livroRepository.deleteById(id);
		return getLivroById(id);
		
	}
}	