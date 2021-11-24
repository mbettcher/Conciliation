package br.com.mtonon.conciliation.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.conciliation.domain.MovimentoDespesa;
import br.com.mtonon.conciliation.repository.MovimentoDespesaRepository;
import br.com.mtonon.conciliation.service.exception.DataIntegrityException;
import br.com.mtonon.conciliation.service.exception.ObjectNotFoundException;

@Service
public class MovimentoDespesaService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MovimentoDespesaRepository repo;
	
	public List<MovimentoDespesa> findAll(){
		return repo.findAll();
	}
	
	public MovimentoDespesa findById(Long id) {
		Optional<MovimentoDespesa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + MovimentoDespesa.class.getName())
				);
	}
	
	public MovimentoDespesa save(MovimentoDespesa obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public MovimentoDespesa update(MovimentoDespesa obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Long id) {
		findById(id);
		try {
			repo.deleteById(id);
		}catch(DataIntegrityException e) {
			throw new DataIntegrityException(
					"Não é possível excluir um Movimento de Despesa que esteja sendo usado por outra tabela!"
					);
		}
	}

}
