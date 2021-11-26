package br.com.mtonon.conciliation.domain;

import java.io.Serializable;
import java.time.LocalDate;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "movimento_despesa")
public class MovimentoDespesa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long id;
	
	@Column(name = "exercicio")
	private Integer ano;
	
	@Column(name = "competencia")
	private Integer mes;
	
	@Column(name = "data_movimento")
	private LocalDate dataMovimento;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "movimento_tem_despesa",
			joinColumns = @JoinColumn(name = "movimento_codigo"),
			inverseJoinColumns = @JoinColumn(name = "despesa_codigo")
			)
	private List<Despesa> despesas = new ArrayList<>();
	
	@OneToMany(mappedBy = "id.movimentoDespesa")
	private Set<ItemMovimentoDespesa> itens = new HashSet<>();
	
	public MovimentoDespesa() {
	}

	public MovimentoDespesa(Long id, Integer ano, Integer mes, LocalDate dataMovimento) {
		super();
		this.id = id;
		this.ano = ano;
		this.mes = mes;
		this.dataMovimento = dataMovimento;
	}

	public double getTotalDespesa() {
		double soma = 0.00;
		for(ItemMovimentoDespesa id : itens) {
			soma = soma + id.getValor();
		}
		return soma;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public LocalDate getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(LocalDate dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public List<Despesa> getDespesas() {
		return despesas;
	}

	public void setDespesas(List<Despesa> despesas) {
		this.despesas = despesas;
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
		MovimentoDespesa other = (MovimentoDespesa) obj;
		return Objects.equals(id, other.id);
	}
}
