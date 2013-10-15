package br.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.model.EnumPergunta;
import br.model.Usuario;
import br.service.UsuarioService;
import br.util.FacesContextUtil;
import br.util.FacesContextUtil.Severity;

@RequestScoped
@ManagedBean(name = "cadastroController")
public class CadastroController{

	private Usuario usuario;
	private Integer confirmaSenha;
	
	@ManagedProperty( "#{usuarioService}" )
	private UsuarioService usuarioService;
	
	@PostConstruct
	public void inicializar() {
		this.usuario = new Usuario();
	}

	public void salvar(){
		if (!this.validaSalvar()){
			return;
		}
		
		usuarioService.salvar(this.usuario);
		FacesContextUtil.addMessage(Severity.WARN, "Cadastro efetuado com sucesso!", null, true);
	}
	
	public void limparCampos(){
		this.usuario = new Usuario();
		this.confirmaSenha = null;
	}
	
	private boolean validaSalvar() {
		if (this.usuario.getSenha() == null){
			FacesContextUtil.addMessage(Severity.WARN, "Por favor, preencha o campo Senha.", null, true);
			return false;
		}else if (this.confirmaSenha == null){
			FacesContextUtil.addMessage(Severity.WARN, "Por favor, preencha a confirmação da Senha.", null, true);
			return false;
		}else if (!this.usuario.getSenha().equals(this.confirmaSenha)){
			FacesContextUtil.addMessage(Severity.WARN, "A senha e a confirmação da senha devem ser iguais.", null, true);
			return false;
		}
		
		if (this.usuario.getCpf() == null ){
			FacesContextUtil.addMessage(Severity.WARN, "Por favor, preencha o campo CPF.", null, true);
			return false;
		}

		if (this.usuario.getNome() == null ){
			FacesContextUtil.addMessage(Severity.WARN, "Por favor, preencha o campo Nome.", null, true);
			return false;
		}

		if (this.usuario.getDataNascimento() == null ){
			FacesContextUtil.addMessage(Severity.WARN, "Por favor, preencha o campo Data de Nascimento.", null, true);
			return false;
		}

		if (this.usuario.getTelefone() == null ){
			FacesContextUtil.addMessage(Severity.WARN, "Por favor, preencha o campo Telefone.", null, true);
			return false;
		}

		if (this.usuario.getResposta() == null ){
			FacesContextUtil.addMessage(Severity.WARN, "Por favor, preencha o campo Resposta.", null, true);
			return false;
		}

		return true;
	}
	
	/*-------------------*/
	/* Getters & Setters */
	/*-------------------*/
	
	public EnumPergunta[] getListaPerguntas() {
		return EnumPergunta.values();
	}
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(Integer confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
}
