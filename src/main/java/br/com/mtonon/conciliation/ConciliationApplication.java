package br.com.mtonon.conciliation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mtonon.conciliation.domain.Despesa;
import br.com.mtonon.conciliation.domain.ItemMovimentoDespesa;
import br.com.mtonon.conciliation.domain.ItemMovimentoReceita;
import br.com.mtonon.conciliation.domain.MovimentoDespesa;
import br.com.mtonon.conciliation.domain.MovimentoReceita;
import br.com.mtonon.conciliation.domain.Receita;
import br.com.mtonon.conciliation.repository.DespesaRepository;
import br.com.mtonon.conciliation.repository.ItemMovimentoDespesaRepository;
import br.com.mtonon.conciliation.repository.ItemMovimentoReceitaRepository;
import br.com.mtonon.conciliation.repository.MovimentoDespesaRepository;
import br.com.mtonon.conciliation.repository.MovimentoReceitaRepository;
import br.com.mtonon.conciliation.repository.ReceitaRepository;

@SpringBootApplication
public class ConciliationApplication implements CommandLineRunner{
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	@Autowired
	private MovimentoReceitaRepository movimentoReceitaRepository;
	
	@Autowired
	private ItemMovimentoReceitaRepository itemMovimentoReceitaRepository;
	
	@Autowired
	private DespesaRepository despesaRepository;
	
	@Autowired
	private MovimentoDespesaRepository movimentoDespesaRepository;
	
	@Autowired
	private ItemMovimentoDespesaRepository itemMovimentoDespesaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ConciliationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/* Instanciação dos objetos Receita */
		Receita receita1 = new Receita(null, "ICMS", false, new BigDecimal(0.0500), true, LocalDateTime.now());
		Receita receita2 = new Receita(null, "FPM", false, new BigDecimal(0.0500), true, LocalDateTime.now());
		Receita receita3 = new Receita(null, "IPI", false, new BigDecimal(0.0500), true, LocalDateTime.now());
		Receita receita4 = new Receita(null, "LEI COMPLEMENTAR 87/96", false, new BigDecimal(0.05), true, LocalDateTime.now());
		Receita receita5 = new Receita(null, "ITR", false, new BigDecimal(0.0500), true, LocalDateTime.now());
		Receita receita6 = new Receita(null, "IPVA", false, new BigDecimal(0.0500), true, LocalDateTime.now());
		Receita receita7 = new Receita(null, "IPTU", true, new BigDecimal(0.2500), true, LocalDateTime.now());
		
		/* Instanciação do objeto MovimentoReceita*/
		MovimentoReceita movimento1 = new MovimentoReceita(null, 2021, 1, LocalDate.now(), new BigDecimal(274.4200).setScale(4, RoundingMode.HALF_EVEN), new BigDecimal(474.27).setScale(4, RoundingMode.HALF_EVEN), new BigDecimal(8601675.3300).setScale(4, RoundingMode.HALF_EVEN));
		
		/* Peenchimento da Lista */
		receita1.getMovimentosReceita().addAll(Arrays.asList(movimento1));
		receita2.getMovimentosReceita().addAll(Arrays.asList(movimento1));
		receita3.getMovimentosReceita().addAll(Arrays.asList(movimento1));
		receita4.getMovimentosReceita().addAll(Arrays.asList(movimento1));
		receita5.getMovimentosReceita().addAll(Arrays.asList(movimento1));
		receita6.getMovimentosReceita().addAll(Arrays.asList(movimento1));
		receita7.getMovimentosReceita().addAll(Arrays.asList(movimento1));
		
		/* Preenchimento da lista*/
		movimento1.getReceitas().addAll(Arrays.asList(receita1,receita2,receita3,receita4,receita5,receita6,receita7));
		
		receitaRepository.saveAll(Arrays.asList(receita1, receita2, receita3, receita4,receita5,receita6,receita7));
		movimentoReceitaRepository.saveAll(Arrays.asList(movimento1));
		
		
		ItemMovimentoReceita itemReceita1 = new ItemMovimentoReceita(movimento1, receita1, new BigDecimal(2854606.27));
		ItemMovimentoReceita itemReceita2 = new ItemMovimentoReceita(movimento1, receita2, new BigDecimal(4982544.64));
		ItemMovimentoReceita itemReceita3 = new ItemMovimentoReceita(movimento1, receita3, new BigDecimal(53519.54));
		ItemMovimentoReceita itemReceita4 = new ItemMovimentoReceita(movimento1, receita4, new BigDecimal(0.00));
		ItemMovimentoReceita itemReceita5 = new ItemMovimentoReceita(movimento1, receita5, new BigDecimal(652.63));
		ItemMovimentoReceita itemReceita6 = new ItemMovimentoReceita(movimento1, receita6, new BigDecimal(1084912.83));
		ItemMovimentoReceita itemReceita7 = new ItemMovimentoReceita(movimento1, receita7, new BigDecimal(11065769.37));
		
		movimento1.getItens().addAll(Arrays.asList(itemReceita1,itemReceita2,itemReceita3,itemReceita4,itemReceita5,itemReceita6,itemReceita7));
		receita1.getItens().add(itemReceita1);
		receita2.getItens().add(itemReceita2);
		receita3.getItens().add(itemReceita3);
		receita4.getItens().add(itemReceita4);
		receita5.getItens().add(itemReceita5);
		receita6.getItens().add(itemReceita6);
		receita6.getItens().add(itemReceita7);
		
		itemMovimentoReceitaRepository.saveAll(Arrays.asList(itemReceita1, itemReceita2, itemReceita3, itemReceita4, itemReceita5, itemReceita6, itemReceita7));
	
		Despesa d1 = new Despesa(null, "3.1.90.04", "Ensino Fundamental Contrato Determinado", new BigDecimal(0.7000), true, LocalDateTime.now());
		Despesa d2 = new Despesa(null, "3.1.90.11", "Ensino Fundamental Vencimento Vantagens Fixas", new BigDecimal(0.7000), true, LocalDateTime.now());
		Despesa d3 = new Despesa(null, "3.1.90.16", "Ensino Fundamental Outras Despesas Pessoal", new BigDecimal(0.7000), true, LocalDateTime.now());
		Despesa d4 = new Despesa(null, "3.1.90.13", "Ensino Fundamental Obrigações Patronais INSS", new BigDecimal(0.7000), true, LocalDateTime.now());
		Despesa d5 = new Despesa(null, "3.1.91.13", "Ensino Fundamental Obrigações Patronais IPG", new BigDecimal(0.7000), true, LocalDateTime.now());
		
		MovimentoDespesa md1 = new MovimentoDespesa(null, 2021, 1, LocalDate.now());
		
		d1.getMovimentosDespesa().addAll(Arrays.asList(md1));
		d2.getMovimentosDespesa().addAll(Arrays.asList(md1));
		d3.getMovimentosDespesa().addAll(Arrays.asList(md1));
		d4.getMovimentosDespesa().addAll(Arrays.asList(md1));
		d5.getMovimentosDespesa().addAll(Arrays.asList(md1));
		
		md1.getDespesas().addAll(Arrays.asList(d1,d2,d3,d4,d5));
		
		despesaRepository.saveAll(Arrays.asList(d1,d2,d3,d4,d5));
		movimentoDespesaRepository.saveAll(Arrays.asList(md1));
		
		ItemMovimentoDespesa imd1 = new ItemMovimentoDespesa(md1, d1, new BigDecimal(1203499.9000));
		ItemMovimentoDespesa imd2 = new ItemMovimentoDespesa(md1, d2, new BigDecimal(0.0000));
		ItemMovimentoDespesa imd3 = new ItemMovimentoDespesa(md1, d3, new BigDecimal(0.0000));
		ItemMovimentoDespesa imd4 = new ItemMovimentoDespesa(md1, d4, new BigDecimal(0.0000));
		ItemMovimentoDespesa imd5 = new ItemMovimentoDespesa(md1, d5, new BigDecimal(460590.6200));
		
		md1.getItens().addAll(Arrays.asList(imd1,imd2,imd3,imd4,imd5));
		d1.getItens().add(imd1);
		d2.getItens().add(imd2);
		d3.getItens().add(imd3);
		d4.getItens().add(imd4);
		d5.getItens().add(imd5);
		
		itemMovimentoDespesaRepository.saveAll(Arrays.asList(imd1,imd2,imd3,imd4,imd5));
	}


}
