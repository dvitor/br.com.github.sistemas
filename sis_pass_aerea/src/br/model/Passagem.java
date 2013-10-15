package br.model;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;

@Entity
public class Passagem {

	@NotNull
	@Id
	@Column(unique = true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	@ForeignKey(name = "FK_PASSAGEM_USUARIO")
	private Usuario usuario;
	
	@Enumerated(EnumType.STRING)
	private EnumTipoPassagem tipoPassagem;
	
	@Enumerated(EnumType.STRING)
	private EnumOrigemDestino origem;
	
	@Enumerated(EnumType.STRING)
	private EnumOrigemDestino destino;
	
	private Date dataIda;
	
	private Date dataVolta;
	
	private Integer qtdeAdulto;

	private Integer qtdeCrianca;
	
	private Integer qtdeBebe;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar horaIda;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar horaVolta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public EnumTipoPassagem getTipoPassagem() {
		return tipoPassagem;
	}

	public void setTipoPassagem(EnumTipoPassagem tipoPassagem) {
		this.tipoPassagem = tipoPassagem;
	}

	public EnumOrigemDestino getOrigem() {
		return origem;
	}

	public void setOrigem(EnumOrigemDestino origem) {
		this.origem = origem;
	}

	public EnumOrigemDestino getDestino() {
		return destino;
	}

	public void setDestino(EnumOrigemDestino destino) {
		this.destino = destino;
	}

	public Date getDataIda() {
		return dataIda;
	}

	public void setDataIda(Date dataIda) {
		this.dataIda = dataIda;
	}

	public Date getDataVolta() {
		return dataVolta;
	}

	public void setDataVolta(Date dataVolta) {
		this.dataVolta = dataVolta;
	}

	public Integer getQtdeAdulto() {
		return qtdeAdulto;
	}

	public void setQtdeAdulto(Integer qtdeAdulto) {
		this.qtdeAdulto = qtdeAdulto;
	}

	public Integer getQtdeCrianca() {
		return qtdeCrianca;
	}

	public void setQtdeCrianca(Integer qtdeCrianca) {
		this.qtdeCrianca = qtdeCrianca;
	}

	public Integer getQtdeBebe() {
		return qtdeBebe;
	}

	public void setQtdeBebe(Integer qtdeBebe) {
		this.qtdeBebe = qtdeBebe;
	}

	public Calendar getHoraIda() {
		return horaIda;
	}

	public void setHoraIda(Calendar horaIda) {
		this.horaIda = horaIda;
	}

	public Calendar getHoraVolta() {
		return horaVolta;
	}

	public void setHoraVolta(Calendar horaVolta) {
		this.horaVolta = horaVolta;
	}
	
	
	
}
