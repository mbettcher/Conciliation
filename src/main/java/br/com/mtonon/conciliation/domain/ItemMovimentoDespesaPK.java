package br.com.mtonon.conciliation.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemMovimentoDespesaPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "despesa_id")
	private Despesa despesa;
	
	@ManyToOne
	@JoinColumn(name = "movimento_id")
	private MovimentoDespesa movimentoDespesa;
	
	public Despesa getDespesa() {
		return despesa;
	}
	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}
	public MovimentoDespesa getMovimentoDespesa() {
		return movimentoDespesa;
	}
	public void setMovimento(MovimentoDespesa movimentoDespesa) {
		this.movimentoDespesa = movimentoDespesa;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(despesa, movimentoDespesa);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemMovimentoDespesaPK other = (ItemMovimentoDespesaPK) obj;
		return Objects.equals(despesa, other.despesa) && Objects.equals(movimentoDespesa, other.movimentoDespesa);
	}
}
