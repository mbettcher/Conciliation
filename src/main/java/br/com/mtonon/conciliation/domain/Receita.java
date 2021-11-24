package br.com.mtonon.conciliation.domain;

import java.io.Serializable;
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

@Entity
@Table(name = "receita")
public class Receita implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long id;
	
	@Column(name = "descricao_receita")
	private String descricao;
	
	@Column(name = "imposto_proprio")
	private Boolean proprio;
	
	@Column(name = "percentual_repasse")
	private Double percentual;
	
	@Column(name = "ativo")
	private Boolean ativo;
	
	@Column(name = "data_cadastro")
	private LocalDateTime dataCadastro;
	
	@ManyToMany(mappedBy = "receitas")
	private List<MovimentoReceita> movimentosReceita = new ArrayList<>();

	@OneToMany(mappedBy = "id.receita")
	private Set<ItemMovimentoReceita> itens = new HashSet<>();
	
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
	
	public List<MovimentoReceita> getMovimentos() {
		List<MovimentoReceita> lista = new ArrayList<>();
		for(ItemMovimentoReceita x : itens) {
			lista.add(x.getMovimentoReceita());
		}
		return lista;
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

	public List<MovimentoReceita> getMovimentosReceita() {
		return movimentosReceita;
	}

	public void setMovimentosReceita(List<MovimentoReceita> movimentosReceita) {
		this.movimentosReceita = movimentosReceita;
	}

	public Set<ItemMovimentoReceita> getItens() {
		return itens;
	}

	public void setItens(Set<ItemMovimentoReceita> itens) {
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
		Receita other = (Receita) obj;
		return Objects.equals(id, other.id);
	}
}
