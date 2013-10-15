package br.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.model.Usuario;
import br.service.UsuarioService;
import br.util.FacesContextUtil;
import br.util.FacesContextUtil.Severity;

@RequestScoped
@ManagedBean(name = "loginController")
public class LoginController {

	private String cpf;
	private Integer senha;
		
	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;
	
	public void efetuarLogin() {
		Usuario usuario = this.usuarioService.consultarUsuario(this.cpf, this.senha);
		if (usuario != null){
			//TODO Abrir a tela de Passagens
			FacesContextUtil.addMessage(Severity.WARN, "Login efetuado com sucesso!", null, true);
		}else{
			FacesContextUtil.addMessage(Severity.WARN, "Login e senha não conferem!", null, true);	
		}
	}
	
	
	/*-------------------*/
	/* Getters & Setters */
	/*-------------------*/
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Integer getSenha() {
		return senha;
	}
	public void setSenha(Integer senha) {
		this.senha = senha;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
}
