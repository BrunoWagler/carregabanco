package com.br.apijava.api.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.apijava.api.Model.AlunoModel;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long> 
{
    @Query("SELECT a FROM AlunoModel a WHERE a.pessoa.nomeEstudante like %:nome%")
    List<AlunoModel> findByNomeEstudante(String nome);

    @Query("SELECT a FROM AlunoModel a WHERE a.campus like %:campus%")
    List<AlunoModel> findByCampus(String campus);

    @Query("SELECT a FROM AlunoModel a WHERE a.curso like %:curso%")
    List<AlunoModel> findByCurso(String curso);

}
