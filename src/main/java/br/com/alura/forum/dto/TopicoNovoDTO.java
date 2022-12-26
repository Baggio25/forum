package br.com.alura.forum.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;

public class TopicoNovoDTO {

	@NotBlank(message = "Campo é obrigatório")
	private String titulo;
	
	@NotBlank(message = "Campo é obrigatório")
	private String mensagem;
	
	@NotNull(message = "Campo é obrigatório")
	private String nomeCurso;

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public Topico converter(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(nomeCurso); 
		return new Topico(titulo, mensagem, curso);
	}

}
