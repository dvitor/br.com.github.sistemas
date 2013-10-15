package br.model;

public enum EnumPergunta {
	NOME_MAE("Qual o nome completo da sua mãe?"),
	BAIRRO_NASCEU("Em que bairro você nasceu?"),
	PROF_FAVORITO("Quem era seu professor favorito?"),
	PRATO_FAVORITO("Qual seu prato favorito?"),
	ANOS_PAI("Quantos anos tem seu pai?");

	private String descricao;

	private EnumPergunta(String descricao){
		this.setDescricao(descricao);		
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}	
