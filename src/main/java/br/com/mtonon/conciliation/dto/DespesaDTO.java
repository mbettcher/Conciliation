package br.com.mtonon.conciliation.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.mtonon.conciliation.domain.Despesa;

public class DespesaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank(message = "O campo Conta deve ser informado!")
	private String conta;
	
	@NotBlank(message = "O campo Descrição deve ser informado!")
	private String descricao;
	
	@NotNull(message = "O campo Percentual de Aplicação deve ser informado!")
	private Double fundeb;
	
	private Boolean ativo;
	

	public DespesaDTO() {
	}
	
	public DespesaDTO(Despesa obj) {
		this.id = obj.getId();
		this.conta = obj.getConta();
		this.descricao = obj.getDescricao();
		this.fundeb = obj.getFundeb();
		this.ativo = obj.getAtivo();
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
}
