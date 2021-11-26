package br.com.mtonon.conciliation.resources;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mtonon.conciliation.domain.Receita;
import br.com.mtonon.conciliation.dto.ReceitaDTO;
import br.com.mtonon.conciliation.service.ReceitaService;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitaResource {
	
	@Autowired
	private ReceitaService receitaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ReceitaDTO>> findAll(){
		List<Receita> list = receitaService.findAll();
		List<ReceitaDTO> listDTO = list.stream().map(obj -> new ReceitaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Receita> findById(@PathVariable Long id) {
		Receita obj = receitaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody ReceitaDTO objDTO) {
		Receita obj = receitaService.fromDTO(objDTO);
		obj.setDataCadastro(LocalDateTime.now());
		receitaService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody ReceitaDTO objDTO, @PathVariable Long id) {
		Receita obj = receitaService.fromDTO(objDTO);
		obj.setId(id);
		obj = receitaService.update(obj);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		receitaService.delete(id);
		return ResponseEntity.ok().build();
	}
}
