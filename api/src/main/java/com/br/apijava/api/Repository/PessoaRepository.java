package com.br.apijava.api.Repository;

import com.br.apijava.api.Model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
}
