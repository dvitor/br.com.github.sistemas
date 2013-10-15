package br.model;

public enum EnumTipoPassagem {
	IDA("Ida."),
	VOLTA("Volta."),
	IDA_VOLTA("Ida e Volta.");

	private String descricao;

	private EnumTipoPassagem(String descricao){
		this.setDescricao(descricao);		
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
