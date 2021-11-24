package br.com.mtonon.conciliation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mtonon.conciliation.domain.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{

}
