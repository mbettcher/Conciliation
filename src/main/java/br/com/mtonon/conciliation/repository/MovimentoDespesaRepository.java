package br.com.mtonon.conciliation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mtonon.conciliation.domain.MovimentoDespesa;

@Repository
public interface MovimentoDespesaRepository extends JpaRepository<MovimentoDespesa, Long>{

}
