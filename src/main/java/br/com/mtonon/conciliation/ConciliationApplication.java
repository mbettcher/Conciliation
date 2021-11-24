package br.com.mtonon.conciliation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mtonon.conciliation.domain.Despesa;
import br.com.mtonon.conciliation.domain.ItemMovimentoReceita;
import br.com.mtonon.conciliation.domain.MovimentoReceita;
import br.com.mtonon.conciliation.domain.Receita;
import br.com.mtonon.conciliation.repository.DespesaRepository;
import br.com.mtonon.conciliation.repository.ItemMovimentoReceitaRepository;
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
	
	public static void main(String[] args) {
		SpringApplication.run(ConciliationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/* Instanciação dos objetos Receita */
		Receita receita1 = new Receita(null, "ICMS", false, 0.05, true, LocalDateTime.now());
		Receita receita2 = new Receita(null, "FPM", false, 0.05, true, LocalDateTime.now());
		Receita receita3 = new Receita(null, "IPI", false, 0.05, true, LocalDateTime.now());
		Receita receita4 = new Receita(null, "LEI COMPLEMENTAR 87/96", false, 0.05, true, LocalDateTime.now());
		
		/* Instanciação do objeto MovimentoReceita*/
		MovimentoReceita movimento1 = new MovimentoReceita(null, 2021, 1, LocalDate.now());
		
		/* Peenchimento da Lista */
		receita1.getMovimentosReceita().addAll(Arrays.asList(movimento1));
		receita2.getMovimentosReceita().addAll(Arrays.asList(movimento1));
		receita3.getMovimentosReceita().addAll(Arrays.asList(movimento1));
		receita4.getMovimentosReceita().addAll(Arrays.asList(movimento1));
		
		/* Preenchimento da lista*/
		movimento1.getReceitas().addAll(Arrays.asList(receita1,receita2,receita3,receita4));
		
		receitaRepository.saveAll(Arrays.asList(receita1, receita2, receita3, receita4));
		movimentoReceitaRepository.saveAll(Arrays.asList(movimento1));
		
		
		ItemMovimentoReceita itemReceita1 = new ItemMovimentoReceita(movimento1, receita1, 2854606.27, 142730.31);
		ItemMovimentoReceita itemReceita2 = new ItemMovimentoReceita(movimento1, receita2, 4982544.64, 249127.23);
		ItemMovimentoReceita itemReceita3 = new ItemMovimentoReceita(movimento1, receita3, 53519.54, 2675.98);
		ItemMovimentoReceita itemReceita4 = new ItemMovimentoReceita(movimento1, receita4, 0.00, 0.00);
		
		movimento1.getItens().addAll(Arrays.asList(itemReceita1,itemReceita2,itemReceita3,itemReceita4));
		receita1.getItens().add(itemReceita1);
		receita2.getItens().add(itemReceita2);
		receita3.getItens().add(itemReceita3);
		receita4.getItens().add(itemReceita4);
		
		itemMovimentoReceitaRepository.saveAll(Arrays.asList(itemReceita1, itemReceita2, itemReceita3, itemReceita4));
	
		Despesa d1 = new Despesa(null, "3.1.90.04", "Ensino Fundamental Contrato Determinado", 0.30, true, LocalDateTime.now());
		Despesa d2 = new Despesa(null, "3.1.90.11", "Ensino Fundamental Vencimento Vantagens Fixas", 0.30, true, LocalDateTime.now());
		Despesa d3 = new Despesa(null, "3.1.90.16", "Ensino Fundamental Outras Despesas Pessoal", 0.30, true, LocalDateTime.now());
		Despesa d4 = new Despesa(null, "3.1.90.13", "Ensino Fundamental Obrigações Patronais INSS", 0.30, true, LocalDateTime.now());
		Despesa d5 = new Despesa(null, "3.1.91.13", "Ensino Fundamental Obrigações Patronais IPG", 0.30, true, LocalDateTime.now());
		
		despesaRepository.saveAll(Arrays.asList(d1,d2,d3,d4,d5));
	}


}
