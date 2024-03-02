package br.com.mrocha.desafio6.controller;

import br.com.mrocha.desafio6.domain.Adocao.Adocao;
import br.com.mrocha.desafio6.domain.Adocao.DadosAdocao;
import br.com.mrocha.desafio6.domain.Adocao.DadosCadastroAdocao;
import br.com.mrocha.desafio6.domain.Pets.Pets;
import br.com.mrocha.desafio6.repository.PetsRepository;
import br.com.mrocha.desafio6.repository.TutoresRepository;
import br.com.mrocha.desafio6.service.AdocaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/adocao")
public class AdocaoController {

    @Autowired
    private AdocaoService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAdocao dados) {
        Adocao adocao = service.cadastraAdocao(dados);

        return ResponseEntity.ok(new DadosAdocao(adocao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarTutor(@PathVariable Long id) {
        service.deletarAdocao(id);

        return ResponseEntity.ok("Adocao removida");
    }

}
