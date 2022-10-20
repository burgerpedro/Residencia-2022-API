package br.com.residencia.biblioteca.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.residencia.biblioteca.DTO.ConsultaCnpjDTO;
import br.com.residencia.biblioteca.DTO.EditoraDTO;
import br.com.residencia.biblioteca.entity.Editora;
import br.com.residencia.biblioteca.service.EditoraService;

@RestController
@RequestMapping("/editoras")
public class EditoraController {
	
	@Autowired
	EditoraService editoraService;
	
	
	@GetMapping("/consulta/{cnpj}")
	public ResponseEntity <ConsultaCnpjDTO> consultaCnpjApiExterna(@PathVariable String cnpj){
				 ConsultaCnpjDTO consultaCnpjDTO = editoraService.consultaCnpjApiExterna(cnpj);
			if(consultaCnpjDTO == null)
				 return new ResponseEntity<> (consultaCnpjDTO,HttpStatus.NOT_FOUND);
			else
			return new ResponseEntity<> (consultaCnpjDTO,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity <List<Editora>> getAllEditoras(){
		return new ResponseEntity<>(editoraService.gettAllEditoras(),HttpStatus.OK);
	}
	
	
	@GetMapping("/dto")
	public ResponseEntity <List<EditoraDTO>> getAllEditorasDTO(){
		return new ResponseEntity<>(editoraService.gettAllEditorasDTO(),HttpStatus.OK);
	}
	
	@GetMapping("/editora-livros")
	public ResponseEntity <List<EditoraDTO>> getAllLivrosEditorasDTO(){
		return new ResponseEntity<>(editoraService.gettAllLivrosEditoraDTO(),HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Editora> getEditoraById(@PathVariable Integer id){
		Editora editora = editoraService.getEditoraById(id);
		if(editora != null)
			return new ResponseEntity<> (editora,HttpStatus.OK);
		else 
			return new ResponseEntity<>(editora,HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/dto/{id}")
	public ResponseEntity<EditoraDTO> getEditoraByIdDTO(@PathVariable Integer id){
		EditoraDTO editoraDTO = editoraService.getEditoraByIdDTO(id);
		if(editoraDTO != null)
			return new ResponseEntity<> (editoraDTO,HttpStatus.OK);
		else 
			return new ResponseEntity<>(editoraDTO,HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/cnpj/{cnpj}")
	public ResponseEntity<Editora> saveEditoraFromApi(@PathVariable String cnpj) {
		return new  ResponseEntity<>(editoraService.saveEditorafromApi(cnpj),HttpStatus.CREATED);
	}	
		
	@PostMapping("/dto")
	public ResponseEntity<EditoraDTO> saveEditoraDTO (@RequestBody EditoraDTO editoraDTO) {
		return new  ResponseEntity<>(editoraService.saveEditoraDTO(editoraDTO),HttpStatus.CREATED);
		
	}
	
	@PostMapping
	public ResponseEntity<Editora> saveEditora(@RequestBody Editora editora) {
		return new ResponseEntity<>(editoraService.saveEditora(editora),HttpStatus.CREATED);
		}
	
	@PostMapping(value = "/cadastro-editora-com-foto", consumes = {MediaType.APPLICATION_JSON_VALUE ,MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<EditoraDTO> saveEditoraFoto(@RequestPart("editora") String editoraTxt, @RequestPart ("filename") MultipartFile file) throws IOException{
			
		EditoraDTO editoraDTO = editoraService.saveEditoraFoto(editoraTxt, file);
		
		if(editoraDTO == null)
			return new ResponseEntity<>(editoraDTO,HttpStatus.BAD_REQUEST);
			else
				return new ResponseEntity<>(editoraDTO,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Editora> updateeditora(@RequestBody Editora editora,@PathVariable Integer id){
		return new ResponseEntity<>(editoraService.updateEditora(editora, id),HttpStatus.OK);
	}
	
	@PutMapping("/dto/{id}")
	public ResponseEntity<EditoraDTO> updateeditoraDTO(@RequestBody EditoraDTO editoraDTO,@PathVariable Integer id){
		return new ResponseEntity<>(editoraService.updateEditoraDTO(editoraDTO, id),HttpStatus.OK);
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
