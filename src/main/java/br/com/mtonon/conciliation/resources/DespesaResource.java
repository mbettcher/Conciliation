package br.com.mtonon.conciliation.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.conciliation.domain.Despesa;
import br.com.mtonon.conciliation.service.DespesaService;

@RestController
@RequestMapping(value = "/despesas")
public class DespesaResource {
	
	@Autowired
	private DespesaService despesaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Despesa>> findAll(){
		List<Despesa> list = despesaService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Despesa> findById(@PathVariable Long id){
		Despesa obj = despesaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
