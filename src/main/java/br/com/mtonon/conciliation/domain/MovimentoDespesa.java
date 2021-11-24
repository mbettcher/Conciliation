package br.com.mtonon.conciliation.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
	
	@ManyToMany
	@JoinTable(name = "movimento_tem_despesa",
			joinColumns = @JoinColumn(name = "movimento_codigo"),
			inverseJoinColumns = @JoinColumn(name = "despesa_codigo")
			)
	private List<Despesa> despesas = new ArrayList<>();
	
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
