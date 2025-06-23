package com.br.apijava.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.apijava.api.Model.AlunoModel;
import com.br.apijava.api.Repository.AlunoRepository;
import com.br.apijava.api.Repository.PessoaRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController 
{

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping("/inserir")
    public ResponseEntity<AlunoModel> inserir(@RequestBody AlunoModel aluno) 
    {
        
        if (aluno.getPessoa() != null && aluno.getPessoa().getIdPessoa() != null) {
            var pessoaExistente = pessoaRepository.findById(aluno.getPessoa().getIdPessoa());
            if (pessoaExistente.isPresent()) {
                aluno.setPessoa(pessoaExistente.get());
            } else {
                return ResponseEntity.badRequest().build();
            }
        }

        AlunoModel salvo = alunoRepository.save(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping("/todos")
    public List<AlunoModel> listarTodos() {
        return alunoRepository.findAll();
    }
}