package br.com.mtonon.conciliation.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class MovimentoDespesa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private Integer ano;
	private Integer mes;
	private LocalDate dataMovimento;
	
	public MovimentoDespesa() {
	}

	public MovimentoDespesa(Long id, Integer ano, Integer mes, LocalDate dataMovimento) {
		super();
		this.id = id;
		this.ano = ano;
		this.mes = mes;
		this.dataMovimento = dataMovimento;
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
