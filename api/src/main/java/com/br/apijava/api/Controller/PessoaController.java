package com.br.apijava.api.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.apijava.api.Model.PessoaModel;
import com.br.apijava.api.Repository.PessoaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaRepository repository;

    public PessoaController(PessoaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/todos")
    public List<PessoaModel> getAll() {
        return repository.findAll();
    }

    @PostMapping("/inserir")
    public PessoaModel inserir(@RequestBody @Valid PessoaModel novaPessoa) {
        return repository.save(novaPessoa);
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        repository.deleteById(id);
        return "deletado com sucesso";
    }

    @PutMapping("/atualizar/{id}")
    public PessoaModel atualizar(@PathVariable Long id, @RequestBody @Valid PessoaModel pessoaAtualizada) {
        PessoaModel pessoaExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com o id: " + id));

        pessoaExistente.setNomeEstudante(pessoaAtualizada.getNomeEstudante());
        pessoaExistente.setIdade(pessoaAtualizada.getIdade());
        pessoaExistente.setSexo(pessoaAtualizada.getSexo());

        return repository.save(pessoaExistente);
    }

}
