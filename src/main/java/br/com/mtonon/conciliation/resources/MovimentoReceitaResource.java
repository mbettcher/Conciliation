package br.com.mtonon.conciliation.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.conciliation.domain.MovimentoReceita;
import br.com.mtonon.conciliation.service.MovimentoReceitaService;

@RestController
@RequestMapping(value = "/movimentos/receita")
public class MovimentoReceitaResource {

	@Autowired
	private MovimentoReceitaService movimentoReceitaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MovimentoReceita>> findAll(){
		List<MovimentoReceita> list = movimentoReceitaService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
