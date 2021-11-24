package br.com.mtonon.conciliation.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.conciliation.domain.Receita;
import br.com.mtonon.conciliation.service.ReceitaService;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitaResource {
	
	@Autowired
	private ReceitaService receitaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Receita>> findAll(){
		List<Receita> list = receitaService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Receita> findById(@PathVariable Long id) {
		Receita obj = receitaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
