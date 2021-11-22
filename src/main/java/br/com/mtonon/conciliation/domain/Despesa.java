package br.com.mtonon.conciliation.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Despesa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String descricao;
	private Double fundeb;
	private Boolean ativo;
	private LocalDateTime dataCadastro;
	
	public Despesa() {
	}

	public Despesa(Long id, String descricao, Double fundeb, Boolean ativo, LocalDateTime dataCadastro) {
		super();
		this.id = id;
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
