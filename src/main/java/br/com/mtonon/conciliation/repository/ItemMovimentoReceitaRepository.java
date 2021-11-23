package br.com.mtonon.conciliation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mtonon.conciliation.domain.ItemMovimentoReceita;

@Repository
public interface ItemMovimentoReceitaRepository extends JpaRepository<ItemMovimentoReceita, Long>{

}
