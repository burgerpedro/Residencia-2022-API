package br.com.residencia.biblioteca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.DTO.EditoraDTO;
import br.com.residencia.biblioteca.entity.Editora;
import br.com.residencia.biblioteca.repository.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	EditoraRepository editoraRepository;
	
	public List<Editora> gettAllEditoras() {
	return editoraRepository.findAll();

	}
	
	public List<EditoraDTO> gettAllEditorasDTO2(){
			List<Editora> editoras = editoraRepository.findAll();
			List<EditoraDTO> editorasDTO = new ArrayList<EditoraDTO>();
			
			for(Editora editora: editoras) {
			editorasDTO.add(new EditoraDTO(editora));
			}
			return editorasDTO;
		
	}
	
	public List<EditoraDTO> gettAllEditorasDTO(){
	return editoraRepository.findAll().stream().map(EditoraDTO::new).collect(Collectors.toList());
	//stream devolve uma coleção e habilita metodos/ map mapeia os objetos e cria novos objetos collector tras uma lista com os objetos
	}
	
	
	public Editora getEditoraById(Integer id) {
		return editoraRepository.findById(id).orElse(null);
	}
	
	public Editora getEditoraDTOById(Integer id) {
		//return editoraRepository.findById(id).get();
		return editoraRepository.findById(id).orElse(null);
	}
	
	public EditoraDTO saveEditoraDTO(EditoraDTO editoraDTO) {
		Editora editora = new Editora(editoraDTO);
		return new EditoraDTO(editoraRepository.save(editora));
		
	}
	
	public Editora saveEditora(Editora editora) {
		return editoraRepository.save(editora);
		
	}
	
	
	public Editora updateEditora(Editora editora,Integer id) {
		
		Editora editoraExisteNoBanco = getEditoraById(id);
		
		editoraExisteNoBanco.setNome(editora.getNome());
					
		return editoraRepository.save(editora);
		
	}
	
	public Editora deleteEditora(Integer id) {
		editoraRepository.deleteById(id);
		
		return getEditoraById(id);
	}
}
