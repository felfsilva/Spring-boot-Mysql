package br.com.felipe.springbootmysql.controller;

import br.com.felipe.springbootmysql.controller.dto.PessoaRq;
import br.com.felipe.springbootmysql.controller.dto.PessoaRs;
import br.com.felipe.springbootmysql.model.Pessoa;
import br.com.felipe.springbootmysql.repository.PessoaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping("/")
    public List<PessoaRs> findAll(){

        var pessoas = pessoaRepository.findAll();
        return pessoas.stream().map((p) -> PessoaRs.converter(p)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PessoaRs findById(@PathVariable("id") Long id) {
        var pessoa = pessoaRepository.getOne(id);
        return PessoaRs.converter(pessoa);
    }

    @PostMapping("/")
    public void savePerson(@RequestBody PessoaRq pessoa) {
        var p = new Pessoa();
        p.setNome(pessoa.getNome());
        p.setSobrenome(pessoa.getSobrenome());
        pessoaRepository.save(p);

    }
}
