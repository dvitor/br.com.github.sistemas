package br.model;

public enum EnumOrigemDestino {
	
	SP("São Paulo."),
	RJ("Rio de Janeiro"),
	BA("Bahia"),
	MG("Minas Gerais"),;

	private String descricao;

	private EnumOrigemDestino(String descricao){
		this.setDescricao(descricao);		
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
