package br.com.alura.forum.config.validacao.dto;

public class ErroFormuarioDTO {
	private String campo;
	private String erro;

	public ErroFormuarioDTO() {

	}
	
	public ErroFormuarioDTO(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
}
