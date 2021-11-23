package br.com.mtonon.conciliation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mtonon.conciliation.domain.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long>{

}
