package br.com.mtonon.conciliation.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "movimento_receita")
public class MovimentoReceita implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long id;
	
	@Column(name = "exercicio")
	private Integer ano;
	
	@Column(name = "competencia")
	private Integer mes;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_movimento")
	private LocalDate dataMovimento;
	
	private BigDecimal rendimentoF30;
	
	private BigDecimal rendimentoF70;
	
	private BigDecimal repasseDoFundeb;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "movimento_tem_receita",
		joinColumns = @JoinColumn(name = "movimento_codigo"),
		inverseJoinColumns = @JoinColumn(name = "receita_codigo")
	)
	private List<Receita> receitas = new ArrayList<>();
	
	@OneToMany(mappedBy = "id.movimentoReceita")
	private Set<ItemMovimentoReceita> itens = new HashSet<>();
	
	public MovimentoReceita() {
	}

	public MovimentoReceita(Long id, Integer ano, Integer mes, LocalDate dataMovimento, BigDecimal rendimentoF30,
			BigDecimal rendimentoF70, BigDecimal repasseDoFundeb) {
		super();
		this.id = id;
		this.ano = ano;
		this.mes = mes;
		this.dataMovimento = dataMovimento;
		this.rendimentoF30 = rendimentoF30;
		this.rendimentoF70 = rendimentoF70;
		this.repasseDoFundeb = repasseDoFundeb;
	}
	
	public BigDecimal getTotalRendimentos() {
		return rendimentoF30.add(rendimentoF70);
	}
	
	public BigDecimal getTotalRendimentosMaisRepasse() {
		return repasseDoFundeb.add(rendimentoF30.add(rendimentoF70));
	}

	public BigDecimal getSubtotalNaoProprio() {
		BigDecimal soma = new BigDecimal(0.0000).setScale(4, RoundingMode.HALF_EVEN);
		for(ItemMovimentoReceita ir : itens) {
			if(!ir.getReceita().getProprio()) {
				soma = soma.add(ir.getValorArrecadado());
			}
		}
		return soma;
	}
	
	public BigDecimal getSubtotalProprio() {
		BigDecimal soma = new BigDecimal(0.0000).setScale(4, RoundingMode.HALF_EVEN);
		for(ItemMovimentoReceita ir : itens) {
			if(ir.getReceita().getProprio()) {
				soma = soma.add(ir.getValorArrecadado());
			}
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


	public BigDecimal getRendimentoF30() {
		return rendimentoF30;
	}

	public void setRendimentoF30(BigDecimal rendimentoF30) {
		this.rendimentoF30 = rendimentoF30;
	}

	public BigDecimal getRendimentoF70() {
		return rendimentoF70;
	}

	public void setRendimentoF70(BigDecimal rendimentoF70) {
		this.rendimentoF70 = rendimentoF70;
	}

	public BigDecimal getRepasseDoFundeb() {
		return repasseDoFundeb;
	}

	public void setRepasseDoFundeb(BigDecimal repasseDoFundeb) {
		this.repasseDoFundeb = repasseDoFundeb;
	}

	public List<Receita> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
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
		MovimentoReceita other = (MovimentoReceita) obj;
		return Objects.equals(id, other.id);
	}
}
