package br.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.model.Usuario;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UsuarioDAO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5973546109446478017L;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Usuario consultarUsuario(String cpf, Integer senha) {
		
		String jpql = "SELECT u FROM Usuario u WHERE u.cpf =:pCpf and u.senha = :pSenha";

		Query query = entityManager.createQuery(jpql);
		query.setParameter("pCpf", cpf);
		query.setParameter("pSenha", senha);
		
		try{
			return (Usuario)query.getSingleResult();
		}catch(javax.persistence.NoResultException exception){
			return null;
		}	
	}

	@Transactional
	public void salvar(Usuario usuario) {
		entityManager.persist(usuario);	
	}

}
