package br.com.alura.forum.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.dto.AtualizacaoTopicoFormDTO;
import br.com.alura.forum.dto.DetalhesTopicoDTO;
import br.com.alura.forum.dto.TopicoDTO;
import br.com.alura.forum.dto.TopicoFormDTO;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;

	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<TopicoDTO> lista(String nomeCurso) {
		List<Topico> topicos = new ArrayList<>();
		
		if(nomeCurso == null) {
			topicos = topicoRepository.findAll();
		} else {
			topicos = topicoRepository.findByCursoNome(nomeCurso);
		}
		
		return TopicoDTO.converter(topicos);		
	}
	
	@GetMapping("/{id}")
	public DetalhesTopicoDTO detalhar(@PathVariable Long id) {
		Topico topico = topicoRepository.getReferenceById(id);
		return new DetalhesTopicoDTO(topico);
	}
	
	@PostMapping
	public ResponseEntity<TopicoDTO> salvar(@Valid @RequestBody TopicoFormDTO topicoFormDTO, UriComponentsBuilder uriBuilder) {
		Topico topico = topicoFormDTO.converter(cursoRepository);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDTO(topico));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody AtualizacaoTopicoFormDTO atualizacaoTopicoFormDTO, 
			UriComponentsBuilder uriBuilder) {
		Topico topico = atualizacaoTopicoFormDTO.atualizar(id, topicoRepository);
				
		return ResponseEntity.ok(new TopicoDTO(topico));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		topicoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
