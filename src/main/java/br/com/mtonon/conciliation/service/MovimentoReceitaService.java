package br.com.mtonon.conciliation.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.mtonon.conciliation.domain.MovimentoReceita;
import br.com.mtonon.conciliation.repository.MovimentoReceitaRepository;
import br.com.mtonon.conciliation.service.exception.DataIntegrityException;
import br.com.mtonon.conciliation.service.exception.ObjectNotFoundException;

@Service
public class MovimentoReceitaService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MovimentoReceitaRepository repo;
	
	
	public List<MovimentoReceita> findAll(){
		return repo.findAll();
	}
	
	
	public MovimentoReceita findById(Long id) {
		Optional<MovimentoReceita> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + MovimentoReceita.class.getName())
				);
	}
	
	public MovimentoReceita save(MovimentoReceita obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public MovimentoReceita update(MovimentoReceita obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Long id) {
		findById(id);
		try {
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir um Movimento de Receita que esteja sendo usado por outra tabela!"
					);
		}
	}
}
