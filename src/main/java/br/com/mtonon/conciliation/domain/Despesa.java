package br.com.mtonon.conciliation.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private BigDecimal fundeb;
	
	@Column(name = "ativo")
	private Boolean ativo;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "data_cadastro")
	private LocalDateTime dataCadastro;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "despesas")
	private List<MovimentoDespesa> movimentosDespesa = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.despesa")
	private Set<ItemMovimentoDespesa> itens = new HashSet<>();
	
	public Despesa() {
	}

	public Despesa(Long id, String conta, String descricao, BigDecimal fundeb, Boolean ativo, LocalDateTime dataCadastro) {
		super();
		this.id = id;
		this.conta = conta;
		this.descricao = descricao;
		this.fundeb = fundeb;
		this.ativo = ativo;
		this.dataCadastro = dataCadastro;
	}
	
	@JsonIgnore
	public List<MovimentoDespesa> getMovimentos() {
		List<MovimentoDespesa> lista = new ArrayList<>();
		for(ItemMovimentoDespesa x : itens) {
			lista.add(x.getMovimentoDespesa());
		}
		return lista;
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

	public BigDecimal getFundeb() {
		return fundeb;
	}

	public void setFundeb(BigDecimal fundeb) {
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

	public List<MovimentoDespesa> getMovimentosDespesa() {
		return movimentosDespesa;
	}

	public void setMovimentosDespesa(List<MovimentoDespesa> movimentosDespesa) {
		this.movimentosDespesa = movimentosDespesa;
	}

	public Set<ItemMovimentoDespesa> getItens() {
		return itens;
	}

	public void setItens(Set<ItemMovimentoDespesa> itens) {
		this.itens = itens;
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
