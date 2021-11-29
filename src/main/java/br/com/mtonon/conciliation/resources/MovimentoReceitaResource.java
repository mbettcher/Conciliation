package br.com.mtonon.conciliation.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.conciliation.domain.MovimentoReceita;
import br.com.mtonon.conciliation.service.MovimentoReceitaService;

@RestController
@RequestMapping(value = "/movimentos/receitas")
public class MovimentoReceitaResource {

	@Autowired
	private MovimentoReceitaService movimentoReceitaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MovimentoReceita>> findAll(){
		List<MovimentoReceita> list = movimentoReceitaService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<MovimentoReceita> findById(@PathVariable Long id) {
		MovimentoReceita obj = movimentoReceitaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/competencia", method = RequestMethod.GET)
	public ResponseEntity<MovimentoReceita> findByAnoAndMes(
			@RequestParam(name = "ano") Integer ano, 
			@RequestParam(name = "mes") Integer mes) {
		MovimentoReceita obj = movimentoReceitaService.findByAnoAndMes(ano, mes);
		return ResponseEntity.ok().body(obj);
	}
	
}
