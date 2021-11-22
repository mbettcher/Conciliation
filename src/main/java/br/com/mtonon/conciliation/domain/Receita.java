package br.com.mtonon.conciliation.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Receita {
	
	private Long id;
	private String descricao;
	private Boolean proprio;
	private Double percentual;
	private Boolean ativo;
	private LocalDateTime dataCadastro;
	
	public Receita() {
	}

	public Receita(Long id, String descricao, Boolean proprio, Double percentual, Boolean ativo,
			LocalDateTime dataCadastro) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.proprio = proprio;
		this.percentual = percentual;
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

	public Boolean getProprio() {
		return proprio;
	}

	public void setProprio(Boolean proprio) {
		this.proprio = proprio;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
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
		Receita other = (Receita) obj;
		return Objects.equals(id, other.id);
	}
}
