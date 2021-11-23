package br.com.mtonon.conciliation.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemMovimentoReceitaPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "movimento_receita_id")
	private MovimentoReceita movimentoReceita;
	
	@ManyToOne
	@JoinColumn(name = "receita_id")
	private Receita receita;
	
	public MovimentoReceita getMovimentoReceita() {
		return movimentoReceita;
	}
	public void setMovimentoReceita(MovimentoReceita movimentoReceita) {
		this.movimentoReceita = movimentoReceita;
	}
	public Receita getReceita() {
		return receita;
	}
	public void setReceita(Receita receita) {
		this.receita = receita;
	}
	@Override
	public int hashCode() {
		return Objects.hash(movimentoReceita, receita);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemMovimentoReceitaPK other = (ItemMovimentoReceitaPK) obj;
		return Objects.equals(movimentoReceita, other.movimentoReceita) && Objects.equals(receita, other.receita);
	}

}
