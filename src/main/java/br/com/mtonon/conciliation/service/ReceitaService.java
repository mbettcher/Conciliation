package br.com.mtonon.conciliation.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import br.com.mtonon.conciliation.domain.Receita;
import br.com.mtonon.conciliation.dto.ReceitaDTO;
import br.com.mtonon.conciliation.repository.ReceitaRepository;
import br.com.mtonon.conciliation.service.exception.DataIntegrityException;
import br.com.mtonon.conciliation.service.exception.ObjectNotFoundException;

@Service
public class ReceitaService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ReceitaRepository repo;
	
	
	public List<Receita> findAll(){
		return repo.findAll();
	}
	
	
	public Receita findById(Long id) {
		Optional<Receita> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Receita.class.getName()
				));
	}
	
	public Receita save(Receita obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Receita update(Receita obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Long id) {
		findById(id);
		try {
			repo.deleteById(id);
		}catch(DataAccessException e) {
			throw new DataIntegrityException(
					"Não é possível excluir uma Receita que esteja sendo usada por outra tabela!"
					);
		}
	}
	
	public Receita fromDTO(ReceitaDTO objDTO) {
		return new Receita(objDTO.getId(), objDTO.getDescricao(), objDTO.getProprio(), 
				objDTO.getPercentual(), objDTO.getAtivo(), null);
	}
}
