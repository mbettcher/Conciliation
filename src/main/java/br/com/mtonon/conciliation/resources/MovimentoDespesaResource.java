package br.com.mtonon.conciliation.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.conciliation.domain.MovimentoDespesa;
import br.com.mtonon.conciliation.service.MovimentoDespesaService;

@RestController
@RequestMapping(value = "/movimentos/despesas")
public class MovimentoDespesaResource {

	@Autowired
	private MovimentoDespesaService movimentoDespesaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MovimentoDespesa>> findAll(){
		List<MovimentoDespesa> list = movimentoDespesaService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<MovimentoDespesa> findById(@PathVariable Long id) {
		MovimentoDespesa obj = movimentoDespesaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
