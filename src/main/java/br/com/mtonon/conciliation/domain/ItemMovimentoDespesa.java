package br.com.mtonon.conciliation.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "item_despesa")
public class ItemMovimentoDespesa implements Serializable{
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	@Column(name = "codigo")
	private ItemMovimentoDespesaPK id = new ItemMovimentoDespesaPK();
	
	@Column(name = "total_despesa")
	private BigDecimal valor;
	
	public ItemMovimentoDespesa() {
	}

	public ItemMovimentoDespesa(MovimentoDespesa movimento, Despesa despesa, BigDecimal valor) {
		super();
		this.id.setMovimento(movimento);
		this.id.setDespesa(despesa);
		this.valor = valor;
	}

	@JsonIgnore
	public MovimentoDespesa getMovimentoDespesa() {
		return this.id.getMovimentoDespesa();
	}
	
	public Despesa getDespesa() {
		return this.id.getDespesa();
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
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
		ItemMovimentoDespesa other = (ItemMovimentoDespesa) obj;
		return Objects.equals(id, other.id);
	}

}
