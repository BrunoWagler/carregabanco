package com.br.apijava.api.Controller;

import com.br.apijava.api.Model.PessoaModel;
import com.br.apijava.api.Repository.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
