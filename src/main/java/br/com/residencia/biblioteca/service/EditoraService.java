package br.com.residencia.biblioteca.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.residencia.biblioteca.DTO.ConsultaCnpjDTO;
import br.com.residencia.biblioteca.DTO.EditoraDTO;
import br.com.residencia.biblioteca.DTO.LivroDTO;
import br.com.residencia.biblioteca.entity.Editora;
import br.com.residencia.biblioteca.entity.Livro;
import br.com.residencia.biblioteca.repository.EditoraRepository;
import br.com.residencia.biblioteca.repository.LivroRepository;

@Service
public class EditoraService {

	@Autowired
	EditoraRepository editoraRepository;
	
	@Autowired
	LivroRepository livroRepository;
	
	@Autowired
	LivroService livroService;
	
	public List<Editora> gettAllEditoras() {
	return editoraRepository.findAll();

	}
	/*
	public List<EditoraDTO> gettAllEditorasDTO(){
			List<Editora> editoras = editoraRepository.findAll();
			List<EditoraDTO> editorasDTO = new ArrayList<EditoraDTO>();
			
			for(Editora editora: editoras) {
			editorasDTO.add(new EditoraDTO(editora));
			}
			return editorasDTO;
			//com construtor
			
		
		
	}
	
	public List<EditoraDTO> gettAllEditorasDTO(){
	return editoraRepository.findAll().stream().map(EditoraDTO::new).collect(Collectors.toList());
	//stream devolve uma coleção e habilita metodos/ map mapeia os objetos e cria novos objetos collector tras uma lista com os objetos
	}
	
	*/
	
	public List<EditoraDTO> gettAllEditorasDTO(){
		List<Editora> editoras = editoraRepository.findAll();
		List<EditoraDTO> editorasDTO = new ArrayList<>();
		
		//1. Percorrer a lista de entidades Editora (chamada listaEditora)
		//2. Na lista de entidade, pegar cada entidade existente nela
		for(Editora editora : editoras) {
			
			//3. Transformar cada entidade existente na lista em um DTO
			EditoraDTO editoraDTO = toDTO(editora);
			
				 
			//4. Adicionar cada DTO (que foi transformado a partir da entidade) na lista de DTO
			editorasDTO.add(editoraDTO);
			}
		
		//5. Retornar/devolver a lista de DTO preenchida
		return editorasDTO;
	}
		
	public List<EditoraDTO> gettAllLivrosEditoraDTO(){
		List<Editora> editoras = editoraRepository.findAll();
		List<EditoraDTO> editorasDTO = new ArrayList<>();
		
		
		for(Editora editora : editoras) {
			EditoraDTO editoraDTO = toDTO(editora);
			List<Livro> listaLivros = new ArrayList<>();
			List<LivroDTO> listaLivrosDTO = new ArrayList<>();
			
			listaLivros = livroRepository.findByEditora(editora);
			for(Livro livro : listaLivros) {
				LivroDTO livroDTO = livroService.toDTO(livro);
				listaLivrosDTO.add(livroDTO);
			}
			editoraDTO.setLivrosDTO(listaLivrosDTO);
			
			editorasDTO.add(editoraDTO);
			}
		
		return editorasDTO;
	}

	
	public Editora getEditoraById(Integer id) {
		return editoraRepository.findById(id).orElse(null);
	}
	
	public EditoraDTO getEditoraByIdDTO(Integer id) {
		Editora editora =editoraRepository.findById(id).orElse(null);
		EditoraDTO editoraDTO = toDTO(editora);
		
		return editoraDTO;
	}
	
	
	/*
	public EditoraDTO saveEditoraDTO(EditoraDTO editoraDTO) {
		Editora editora = new Editora(editoraDTO);
		return new EditoraDTO(editoraRepository.save(editora));
	//com construtor	
	}
		/*
		public EditoraDTO saveEditoraDTO2(EditoraDTO editoraDTO) {
			Editora editora = new Editora();
			editora.setNome(editoraDTO.getNome());
			
			Editora novaEditora = editoraRepository.save(editora);
			
			EditoraDTO novaEditoraDTO = new EditoraDTO();
			
			novaEditoraDTO.setCodigoEditora(novaEditora.getCodigoEditora());
			novaEditoraDTO.setNome(novaEditora.getNome());
			return novaEditoraDTO;
			//sem construtor conversao interna dentro do metodo
		}
		*/
		public EditoraDTO saveEditoraDTO(EditoraDTO editoraDTO) {
			Editora editora = toEntidade(editoraDTO);
			Editora novaEditora = editoraRepository.save(editora);
			
			EditoraDTO editoraAtualizadaDTO = toDTO(novaEditora);
			
				return editoraAtualizadaDTO;
			//com metodo de conversao
		}
		/*
		public EditoraDTO saveEditoraDTOotimizado(EditoraDTO editoraDTO) {
			Editora novaEditora = editoraRepository.save(toEntidade(editoraDTO));
			
			return	toDTO(novaEditora);
			//com metodo de conversao
		}
		
		public EditoraDTO saveEditoraDTOotimizado2(EditoraDTO editoraDTO) {
			return	toDTO(editoraRepository.save(toEntidade(editoraDTO)));
			//com metodo de conversao  // prejudicial no entendimento
		}
		
		
		*/
		
	public Editora saveEditora(Editora editora) {
		return editoraRepository.save(editora);
		
	}
	
	public Editora saveEditorafromApi(String cnpj) {
		ConsultaCnpjDTO consultaCnpjDTO = consultaCnpjApiExterna(cnpj);
		
		Editora editora = new Editora();
		editora.setNome(consultaCnpjDTO.getNome());
		
		
		
		return editoraRepository.save(editora);
		
	}
	
	public EditoraDTO updateEditoraDTO(EditoraDTO editoraDTO,Integer id) {
		Editora editoraExisteNoBanco = getEditoraById(id);
		EditoraDTO editoraAtualizadaDTO = new EditoraDTO();
		
		if(editoraExisteNoBanco != null) {
			
			editoraExisteNoBanco = toEntidade(editoraDTO);
			
		//	editoraExisteNoBanco.setNome(editoraDTO.getNome());
			Editora editoraAtualizada = editoraRepository.save(editoraExisteNoBanco);
			
			editoraAtualizadaDTO = toDTO(editoraAtualizada);
			
			//editoraAtualizadaDTO.setCodigoEditora(editoraAtualizada.getCodigoEditora());
			//editoraAtualizadaDTO.setNome(editoraAtualizada.getNome());
		}
		return editoraAtualizadaDTO;
	}
	
	public Editora updateEditora(Editora editora,Integer id) {
		
		Editora editoraExisteNoBanco = getEditoraById(id);
		
		editoraExisteNoBanco.setNome(editora.getNome());
					
		return editoraRepository.save(editoraExisteNoBanco);
		
	}
	
	public Editora deleteEditora(Integer id) {
		editoraRepository.deleteById(id);
		
		return getEditoraById(id);
	}
	
	private Editora toEntidade(EditoraDTO editoraDTO) {
		Editora editora = new Editora();
		
		editora.setNome(editoraDTO.getNome());
		
		return editora;
	}
	
	private EditoraDTO toDTO(Editora editora) {
		EditoraDTO editoraDTO = new EditoraDTO();
		
		editoraDTO.setCodigoEditora(editora.getCodigoEditora());
		editoraDTO.setNome(editora.getNome());
		
		return editoraDTO;
	}
	
	public ConsultaCnpjDTO consultaCnpjApiExterna(String cnpj) {
		
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://receitaws.com.br/v1\n/cnpj/{cnpj}";
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("cnpj", cnpj);
			
		ConsultaCnpjDTO consultaCnpjDTO = restTemplate.getForObject(uri,ConsultaCnpjDTO.class ,params);
		
		return consultaCnpjDTO;
	}
	
}
