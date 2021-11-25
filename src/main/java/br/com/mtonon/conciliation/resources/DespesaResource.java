package br.com.mtonon.conciliation.resources;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mtonon.conciliation.domain.Despesa;
import br.com.mtonon.conciliation.dto.DespesaDTO;
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
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody DespesaDTO objDTO) {
		Despesa obj = despesaService.fromDTO(objDTO);
		obj.setDataCadastro(LocalDateTime.now());
		obj = despesaService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody DespesaDTO objDTO, @PathVariable Long id) {
		Despesa obj = despesaService.fromDTO(objDTO);
		obj.setId(id);
		obj = despesaService.update(obj);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		despesaService.delete(id);
		return ResponseEntity.ok().build();
	}
}
