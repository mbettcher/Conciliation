package br.com.mtonon.conciliation.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.mtonon.conciliation.domain.Receita;

public class ReceitaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank(message = "O campo descrição deve ser preenchido!")
	@Size(min = 2, max = 120, message = "O campo descrição deve ser preenchido com no mínimo 2 e no máximo 120 caracteres!")
	private String descricao;
	
	private Boolean proprio;
	
	@NotNull(message = "O campo percentual de repasse para FUNDEB não pode ser nulo!")
	@Min(0)
	private BigDecimal percentual;
	
	private Boolean ativo;
	
	public ReceitaDTO() {
	}

	public ReceitaDTO(Receita obj) {
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.proprio = obj.getProprio();
		this.percentual = obj.getPercentual();
		this.ativo = obj.getAtivo();
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

	public BigDecimal getPercentual() {
		return percentual;
	}

	public void setPercentual(BigDecimal percentual) {
		this.percentual = percentual;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
