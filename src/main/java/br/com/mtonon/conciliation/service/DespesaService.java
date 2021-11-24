package br.com.mtonon.conciliation.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.conciliation.domain.Despesa;
import br.com.mtonon.conciliation.repository.DespesaRepository;
import br.com.mtonon.conciliation.service.exception.DataIntegrityException;
import br.com.mtonon.conciliation.service.exception.ObjectNotFoundException;

@Service
public class DespesaService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Autowired
	private DespesaRepository repo;
	
	public List<Despesa> findAll() {
		return repo.findAll();
	}

	public Despesa findById(Long id) {
		Optional<Despesa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Despesa.class.getName())
				);
	}
	
	public Despesa save(Despesa obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Despesa update(Despesa obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Long id) {
		findById(id);
		try {
			repo.deleteById(id);
		}catch(DataIntegrityException e) {
			throw new DataIntegrityException(
					"Não é possível excluir uma Despesa que esteja sendo usada por outra tabela!"
					);
		}
	}
}
