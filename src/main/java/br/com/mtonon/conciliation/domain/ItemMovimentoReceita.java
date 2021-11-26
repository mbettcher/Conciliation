package br.com.mtonon.conciliation.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "item_receita")
public class ItemMovimentoReceita implements Serializable{
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	@Column(name = "codigo")
	private ItemMovimentoReceitaPK id = new ItemMovimentoReceitaPK();
	
	@Column(name = "total_arrecadado")
	private Double valorArrecadado;
	
	public ItemMovimentoReceita() {
	}

	public ItemMovimentoReceita(MovimentoReceita movimentoReceita, Receita receita, Double valorArrecadado) {
		super();
		this.id.setMovimentoReceita(movimentoReceita);
		this.id.setReceita(receita);
		this.valorArrecadado = valorArrecadado;
	}

	@JsonIgnore
	public MovimentoReceita getMovimentoReceita() {
		return this.id.getMovimentoReceita();
	}


	public Receita getReceita() {
		return this.id.getReceita();
	}

	public Double getValorArrecadado() {
		return valorArrecadado;
	}

	public void setValorArrecadado(Double valorArrecadado) {
		this.valorArrecadado = valorArrecadado;
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
		ItemMovimentoReceita other = (ItemMovimentoReceita) obj;
		return Objects.equals(id, other.id);
	}
}
