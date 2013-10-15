package br.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import br.dao.UsuarioDAO;
import br.model.Usuario;

@Service("usuarioService")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UsuarioService implements Serializable{
	
	private static final long serialVersionUID = -8931216738659660662L;
	
	@Autowired(required=false)
	private UsuarioDAO dao;

	public Usuario consultarUsuario(String cpf, Integer senha) {
		return this.dao.consultarUsuario(cpf, senha);
	}

	public void salvar(Usuario usuario) {
		this.dao.salvar(usuario);
	}

	public void setDao(UsuarioDAO dao) {
		this.dao = dao;
	}
	
	
	
}
