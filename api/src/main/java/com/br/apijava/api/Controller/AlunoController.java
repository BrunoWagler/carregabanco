package com.br.apijava.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.br.apijava.api.Model.AlunoModel;
import com.br.apijava.api.Repository.AlunoRepository;
import com.br.apijava.api.Repository.PessoaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping("/inserir")
    public ResponseEntity<AlunoModel> inserir(@Valid @RequestBody AlunoModel aluno) 
    {
        if (aluno.getIdPessoa() != null) {
            pessoaRepository.findById(aluno.getIdPessoa()).ifPresent(aluno::setPessoa);
        }

        AlunoModel salvo = alunoRepository.save(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping("/todos")
    public List<AlunoModel> listarTodos() 
    {
        return alunoRepository.findAll();
    }

    @GetMapping("/buscar/nome/{nome}")
    public ResponseEntity<List<AlunoModel>> buscarPorNome(@PathVariable String nome) 
    {
        List<AlunoModel> alunos = alunoRepository.findByNomeEstudante(nome);
      
        return ResponseEntity.ok(alunos);
    }     

    @GetMapping("/buscar/campus/{campus}")
    public ResponseEntity<List<AlunoModel>> buscarPorCampus(@PathVariable String campus)
    {
        List<AlunoModel> alunos = alunoRepository.findByCampus(campus);
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/buscar/curso/{curso}")
    public ResponseEntity<List<AlunoModel>> buscarPorCurso(@PathVariable String curso)
    {
        List<AlunoModel> alunos = alunoRepository.findByCurso(curso);
        return ResponseEntity.ok(alunos);
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) 
    {
        if (!alunoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado com o id: " + id);
        }

        alunoRepository.deleteById(id);
        return ResponseEntity.ok("Aluno deletado com sucesso");
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<AlunoModel> atualizar(@PathVariable Long id, @Valid @RequestBody AlunoModel alunoAtualizado) 
    {
        AlunoModel alunoExistente = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o id: " + id));

        alunoExistente.setCampus(alunoAtualizado.getCampus());
        alunoExistente.setPolo(alunoAtualizado.getPolo());
        alunoExistente.setEmailInstitucional(alunoAtualizado.getEmailInstitucional());
        alunoExistente.setCoordenacao(alunoAtualizado.getCoordenacao());
        alunoExistente.setCurso(alunoAtualizado.getCurso());
        alunoExistente.setSituacao(alunoAtualizado.getSituacao());
        alunoExistente.setPeriodoEntrada(alunoAtualizado.getPeriodoEntrada());

        if (alunoAtualizado.getIdPessoa() != null) 
        {
            pessoaRepository.findById(alunoAtualizado.getIdPessoa()).ifPresent(alunoExistente::setPessoa);
        }

        AlunoModel salvo = alunoRepository.save(alunoExistente);
        return ResponseEntity.ok(salvo);
    }

}
