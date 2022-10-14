package br.com.residencia.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.residencia.biblioteca.DTO.EditoraDTO;
import br.com.residencia.biblioteca.entity.Editora;
import br.com.residencia.biblioteca.service.EditoraService;

@RestController
@RequestMapping("/editoras")
public class EditoraController {
	
	@Autowired
	EditoraService editoraService;
	
	@GetMapping
	public ResponseEntity <List<Editora>> getAllEditoras(){
		return new ResponseEntity<>(editoraService.gettAllEditoras(),HttpStatus.OK);
	}
	
	@GetMapping("/dto2")
	public ResponseEntity <List<EditoraDTO>> getAllEditorasDTO2(){
		return new ResponseEntity<>(editoraService.gettAllEditorasDTO2(),HttpStatus.OK);
	}
	
	
	
	@GetMapping("/dto")
	public ResponseEntity <List<EditoraDTO>> getAllEditorasDTO(){
		return new ResponseEntity<>(editoraService.gettAllEditorasDTO(),HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Editora> getEditoraById(@PathVariable Integer id){
		Editora editora = editoraService.getEditoraById(id);
		if(editora != null)
			return new ResponseEntity<> (editora,HttpStatus.OK);
		else 
			return new ResponseEntity<>(editora,HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/dto")
	public ResponseEntity<EditoraDTO> saveEditoraDTO (@RequestBody EditoraDTO editoraDTO) {
		return new  ResponseEntity<>(editoraService.saveEditoraDTO(editoraDTO),HttpStatus.CREATED);
		
	}
	@PostMapping
	public ResponseEntity<Editora> saveEditora(@RequestBody Editora editora) {
		return new ResponseEntity<>(editoraService.saveEditora(editora),
				HttpStatus.CREATED);
		}
	

	@PutMapping("/{id}")
	public ResponseEntity<Editora> updateeditora(@RequestBody Editora editora,@PathVariable Integer id){
		return new ResponseEntity<>(editoraService.updateEditora(editora, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Editora> deleteeditora(@PathVariable Integer id){
		Editora editora = editoraService.getEditoraById(id);
		if(editora == null)
			return new ResponseEntity<>(editora,HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(editoraService.deleteEditora(id),HttpStatus.OK);
	}
}
