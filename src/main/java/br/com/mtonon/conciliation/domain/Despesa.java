package br.com.mtonon.conciliation.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "despesa")
public class Despesa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long id;
	
	@Column(name = "conta")
	private String conta;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "percentual_fundeb")
	private Double fundeb;
	
	@Column(name = "ativo")
	private Boolean ativo;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "data_cadastro")
	private LocalDateTime dataCadastro;
	
	public Despesa() {
	}

	public Despesa(Long id, String conta, String descricao, Double fundeb, Boolean ativo, LocalDateTime dataCadastro) {
		super();
		this.id = id;
		this.conta = conta;
		this.descricao = descricao;
		this.fundeb = fundeb;
		this.ativo = ativo;
		this.dataCadastro = dataCadastro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getFundeb() {
		return fundeb;
	}

	public void setFundeb(Double fundeb) {
		this.fundeb = fundeb;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Despesa other = (Despesa) obj;
		return Objects.equals(id, other.id);
	}
}
